package com.zookeeper.watcher;

import org.apache.zookeeper.AsyncCallback.*;
import org.apache.zookeeper.*;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.book.recovery.RecoveredAssignments;
import org.apache.zookeeper.book.recovery.RecoveredAssignments.RecoveryCallback;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Master implements Watcher, Closeable {
    private static final Logger LOG = LoggerFactory.getLogger(Master.class);

    public enum MasterStates {
        RUNNING, ELECTED, NOTELECTED
    }

    private volatile MasterStates state = MasterStates.RUNNING;

    public MasterStates getState() {
        return state;
    }

    private ZooKeeper zk;
    private String hostPort;
    private Random random = new Random(this.hashCode());
    private String serverId = Integer.toHexString(random.nextInt());
    private volatile boolean connected = false;
    private volatile boolean expired = false;

    protected ChildrenCache tasksCache;
    protected ChildrenCache workersCache;

    /**
     * Creates a new master instance.
     *
     * @param hostPort
     */
    public Master(String hostPort) {
        this.hostPort = hostPort;
    }



    public void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    /**
     * Closes the ZooKeeper session.
     *
     * @throws IOException
     */
    void stopZK() throws InterruptedException, IOException {
        zk.close();
    }

    /**
     * This method implements the process method of the
     * Watcher interface. We use it to deal with the
     * different states of a session.
     *
     * @param e new session event to be processed
     */
    @Override
    public void process(WatchedEvent e) {
        LOG.info("Processing event: " + e.toString());
        if (e.getType() == Event.EventType.None) {
            switch (e.getState()) {
                case SyncConnected:
                    connected = true;
                    break;
                case Disconnected:
                    connected = false;
                    break;
                case Expired:
                    expired = true;
                    connected = false;
                    LOG.error("Session expiration");
                default:
                    break;
            }
        }
    }


    /**
     * This method creates some parent znodes we need for this example.
     * In the case the master is restarted, then this method does not
     * need to be executed a second time.
     */
    public void bootstrap() {
        createParent("/workers", new byte[0]);
        createParent("/assign", new byte[0]);
        createParent("/tasks", new byte[0]);
        createParent("/status", new byte[0]);
    }

    void createParent(String path, byte[] data) {
        zk.create(path,
                data,
                Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT,
                createParentCallback,
                data);
    }

    StringCallback createParentCallback = new StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    /**
                     * Try again. Note that registering again is not a problem.
                     * If the znode has already been created, then we get a
                     * NODEEXISTS event back.
                     */
                    createParent(path, (byte[]) ctx);

                    break;
                case OK:
                    LOG.info("Parent created");

                    break;
                case NODEEXISTS:
                    LOG.warn("Parent already registered: " + path);

                    break;
                default:
                    LOG.error("Something went wrong: ",
                            KeeperException.create(Code.get(rc), path));
            }
        }
    };

    /**
     * Check if this client is connected.
     *
     * @return boolean ZooKeeper client is connected
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * Check if the ZooKeeper session has expired.
     *
     * @return boolean ZooKeeper session has expired
     */
    boolean isExpired() {
        return expired;
    }

    /*
     **************************************
     **************************************
     * Methods related to master election.*
     **************************************
     **************************************
     */


    /**
     * The story in this callback implementation is the following.
     * We tried to create the master lock znode. If it suceeds, then
     * great, it takes leadership. However, there are a couple of
     * exceptional situations we need to take care of.
     * <p>
     * First, we could get a connection loss event before getting
     * an answer so we are left wondering if the operation went through.
     * To check, we try to read the /master znode. If it is there, then
     * we check if this master is the primary. If not, we run for master
     * again.
     * <p>
     * The second case is if we find that the node is already there.
     * In this case, we call exists to set a watch on the znode.
     */
    StringCallback masterCreateCallback = new StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    checkMaster();

                    break;
                case OK:
                    state = MasterStates.ELECTED;
                    takeLeadership();

                    break;
                case NODEEXISTS:
                    state = MasterStates.NOTELECTED;
                    masterExists();

                    break;
                default:
                    state = MasterStates.NOTELECTED;
                    LOG.error("Something went wrong when running for master.",
                            KeeperException.create(Code.get(rc), path));
            }
            LOG.info("I'm " + (state == MasterStates.ELECTED ? "" : "not ") + "the leader " + serverId);
        }
    };

    public void masterExists() {
        zk.exists("/master",
                masterExistsWatcher,
                masterExistsCallback,
                null);
    }

    StatCallback masterExistsCallback = new StatCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    masterExists();

                    break;
                case OK:
                    break;
                case NONODE:
                    state = MasterStates.RUNNING;
                    runForMaster();
                    LOG.info("It sounds like the previous master is gone, " +
                            "so let's run for master again.");

                    break;
                default:
                    checkMaster();
                    break;
            }
        }
    };

    Watcher masterExistsWatcher = new Watcher() {
        @Override
        public void process(WatchedEvent e) {
            if (e.getType() == EventType.NodeDeleted) {
                assert "/master".equals(e.getPath());

                runForMaster();
            }
        }
    };

    void takeLeadership() {
        LOG.info("Going for list of workers");
        getWorkers();

        (new RecoveredAssignments(zk)).recover(new RecoveryCallback() {
            @Override
            public void recoveryComplete(int rc, List<String> tasks) {
                if (rc == RecoveryCallback.FAILED) {
                    LOG.error("Recovery of assigned tasks failed.");
                } else {
                    LOG.info("Assigning recovered tasks");
                    getTasks();
                }
            }
        });
    }

    /*
     * Run for master. To run for master, we try to create the /master znode,
     * with masteCreateCallback being the callback implementation.
     * In the case the create call succeeds, the client becomes the master.
     * If it receives a CONNECTIONLOSS event, then it needs to check if the
     * znode has been created. In the case the znode exists, it needs to check
     * which server is the master.
     */

    /**
     * Tries to create a /master lock znode to acquire leadership.
     * 1. 创建znode节点/master。如果这个znode节点存在，create 就会失败。
     * 同时我们想在/master节点的数据字段保存对应这个服务器的唯⼀ID。
     * 2. 数据字段只能存储字节数组类型的数据，所以我们将int型转换为⼀个字节数组。
     * 3. 使用开放的ACL策略。
     * 4. 节点类型为EPHEMERAL。
     */
    public void runForMaster() {
        LOG.info("Running for master");
        zk.create("/master",
                serverId.getBytes(),
                Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL,
                masterCreateCallback,
                null);
    }

    DataCallback masterCheckCallback = new DataCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    checkMaster();

                    break;
                case NONODE:
                    runForMaster();

                    break;
                case OK:
                    if (serverId.equals(new String(data))) {
                        state = MasterStates.ELECTED;
                        takeLeadership();
                    } else {
                        state = MasterStates.NOTELECTED;
                        masterExists();
                    }

                    break;
                default:
                    LOG.error("Error when reading data.",
                            KeeperException.create(Code.get(rc), path));
            }
        }
    };

    void checkMaster() {
        zk.getData("/master", false, masterCheckCallback, null);
    }

    /*
     ****************************************************
     ****************************************************
     * Methods to handle changes to the list of workers.*
     ****************************************************
     ****************************************************
     */


    /**
     * This method is here for testing purposes.
     *
     * @return size Size of the worker list
     */
    public int getWorkersSize() {
        if (workersCache == null) {
            return 0;
        } else {
            return workersCache.getList().size();
        }
    }

    Watcher workersChangeWatcher = new Watcher() {
        @Override
        public void process(WatchedEvent e) {
            if (e.getType() == EventType.NodeChildrenChanged) {
                assert "/workers".equals(e.getPath());

                getWorkers();
            }
        }
    };

    void getWorkers() {
        zk.getChildren("/workers",
                workersChangeWatcher,
                workersGetChildrenCallback,
                null);
    }

    ChildrenCallback workersGetChildrenCallback = new ChildrenCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, List<String> children) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    getWorkers();
                    break;
                case OK:
                    LOG.info("Succesfully got a list of workers: "
                            + children.size()
                            + " workers");
                    reassignAndSet(children);
                    break;
                default:
                    LOG.error("getChildren failed",
                            KeeperException.create(Code.get(rc), path));
            }
        }
    };

    /*
     *******************
     *******************
     * Assigning tasks.*
     *******************
     *******************
     */

    void reassignAndSet(List<String> children) {
        List<String> toProcess;

        if (workersCache == null) {
            workersCache = new ChildrenCache(children);
            toProcess = null;
        } else {
            LOG.info("Removing and setting");
            toProcess = workersCache.removedAndSet(children);
        }

        if (toProcess != null) {
            for (String worker : toProcess) {
                getAbsentWorkerTasks(worker);
            }
        }
    }

    void getAbsentWorkerTasks(String worker) {
        zk.getChildren("/assign/" + worker, false, workerAssignmentCallback, null);
    }

    ChildrenCallback workerAssignmentCallback = new ChildrenCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, List<String> children) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    getAbsentWorkerTasks(path);

                    break;
                case OK:
                    LOG.info("Succesfully got a list of assignments: "
                            + children.size()
                            + " tasks");

                    /*
                     * Reassign the tasks of the absent worker.
                     */

                    for (String task : children) {
                        getDataReassign(path + "/" + task, task);
                    }
                    break;
                default:
                    LOG.error("getChildren failed", KeeperException.create(Code.get(rc), path));
            }
        }
    };

    /**
     ************************************************
     * Recovery of tasks assigned to absent worker. *
     ************************************************
     */

    /**
     * Get reassigned task data.
     *
     * @param path Path of assigned task
     * @param task Task name excluding the path prefix
     */
    void getDataReassign(String path, String task) {
        zk.getData(path,
                false,
                getDataReassignCallback,
                task);
    }

    /**
     * Context for recreate operation.
     */
    class RecreateTaskCtx {
        String path;
        String task;
        byte[] data;

        RecreateTaskCtx(String path, String task, byte[] data) {
            this.path = path;
            this.task = task;
            this.data = data;
        }
    }

    /**
     * Get task data reassign callback.
     */
    DataCallback getDataReassignCallback = new DataCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    getDataReassign(path, (String) ctx);

                    break;
                case OK:
                    recreateTask(new RecreateTaskCtx(path, (String) ctx, data));

                    break;
                default:
                    LOG.error("Something went wrong when getting data ",
                            KeeperException.create(Code.get(rc)));
            }
        }
    };

    /**
     * Recreate task znode in /tasks
     *
     * @param ctx Recreate text context
     */
    void recreateTask(RecreateTaskCtx ctx) {
        zk.create("/tasks/" + ctx.task,
                ctx.data,
                Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT,
                recreateTaskCallback,
                ctx);
    }

    /**
     * Recreate znode callback
     */
    StringCallback recreateTaskCallback = new StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    recreateTask((RecreateTaskCtx) ctx);

                    break;
                case OK:
                    deleteAssignment(((RecreateTaskCtx) ctx).path);

                    break;
                case NODEEXISTS:
                    LOG.info("Node exists already, but if it hasn't been deleted, " +
                            "then it will eventually, so we keep trying: " + path);
                    recreateTask((RecreateTaskCtx) ctx);

                    break;
                default:
                    LOG.error("Something wwnt wrong when recreating task",
                            KeeperException.create(Code.get(rc)));
            }
        }
    };

    /**
     * Delete assignment of absent worker
     *
     * @param path Path of znode to be deleted
     */
    void deleteAssignment(String path) {
        zk.delete(path, -1, taskDeletionCallback, null);
    }

    VoidCallback taskDeletionCallback = new VoidCallback() {
        @Override
        public void processResult(int rc, String path, Object rtx) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    deleteAssignment(path);
                    break;
                case OK:
                    LOG.info("Task correctly deleted: " + path);
                    break;
                default:
                    LOG.error("Failed to delete task data" +
                            KeeperException.create(Code.get(rc), path));
            }
        }
    };

    /*
     ******************************************************
     ******************************************************
     * Methods for receiving new tasks and assigning them.*
     ******************************************************
     ******************************************************
     */

    Watcher tasksChangeWatcher = new Watcher() {
        @Override
        public void process(WatchedEvent e) {
            if (e.getType() == EventType.NodeChildrenChanged) {
                assert "/tasks".equals(e.getPath());

                getTasks();
            }
        }
    };

    void getTasks() {
        zk.getChildren("/tasks",
                tasksChangeWatcher,
                tasksGetChildrenCallback,
                null);
    }

    ChildrenCallback tasksGetChildrenCallback = new ChildrenCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, List<String> children) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    getTasks();

                    break;
                case OK:
                    List<String> toProcess;
                    if (tasksCache == null) {
                        tasksCache = new ChildrenCache(children);

                        toProcess = children;
                    } else {
                        toProcess = tasksCache.addedAndSet(children);
                    }

                    if (toProcess != null) {
                        assignTasks(toProcess);
                    }

                    break;
                default:
                    LOG.error("getChildren failed.",
                            KeeperException.create(Code.get(rc), path));
            }
        }
    };

    void assignTasks(List<String> tasks) {
        for (String task : tasks) {
            getTaskData(task);
        }
    }

    void getTaskData(String task) {
        zk.getData("/tasks/" + task,
                false,
                taskDataCallback,
                task);
    }

    DataCallback taskDataCallback = new DataCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    getTaskData((String) ctx);

                    break;
                case OK:
                    /*
                     * Choose worker at random.
                     */
                    List<String> list = workersCache.getList();
                    String designatedWorker = list.get(random.nextInt(list.size()));

                    /*
                     * Assign task to randomly chosen worker.
                     */
                    String assignmentPath = "/assign/" +
                            designatedWorker +
                            "/" +
                            (String) ctx;
                    LOG.info("Assignment path: " + assignmentPath);
                    createAssignment(assignmentPath, data);

                    break;
                default:
                    LOG.error("Error when trying to get task data.",
                            KeeperException.create(Code.get(rc), path));
            }
        }
    };

    void createAssignment(String path, byte[] data) {
        zk.create(path,
                data,
                Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT,
                assignTaskCallback,
                data);
    }

    StringCallback assignTaskCallback = new StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    createAssignment(path, (byte[]) ctx);

                    break;
                case OK:
                    LOG.info("Task assigned correctly: " + name);
                    deleteTask(name.substring(name.lastIndexOf("/") + 1));

                    break;
                case NODEEXISTS:
                    LOG.warn("Task already assigned");

                    break;
                default:
                    LOG.error("Error when trying to assign task.",
                            KeeperException.create(Code.get(rc), path));
            }
        }
    };

    /**
     * Once assigned, we delete the task from /tasks
     */
    void deleteTask(String name) {
        zk.delete("/tasks/" + name, -1, taskDeleteCallback, null);
    }

    VoidCallback taskDeleteCallback = new VoidCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx) {
            switch (Code.get(rc)) {
                case CONNECTIONLOSS:
                    deleteTask(path);

                    break;
                case OK:
                    LOG.info("Successfully deleted " + path);

                    break;
                case NONODE:
                    LOG.info("Task has been deleted already");

                    break;
                default:
                    LOG.error("Something went wrong here, " +
                            KeeperException.create(Code.get(rc), path));
            }
        }
    };

    /**
     * Closes the ZooKeeper session.
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        if (zk != null) {
            try {
                zk.close();
            } catch (InterruptedException e) {
                LOG.warn("Interrupted while closing ZooKeeper session.", e);
            }
        }
    }


    public static void main(String args[]) throws Exception {
        Master m = new Master(args[0]);
        m.startZK();

        while (!m.isConnected()) {
            Thread.sleep(100);
        }

        m.bootstrap();

        m.runForMaster();

        while (!m.isExpired()) {
            Thread.sleep(1000);
        }

        m.stopZK();
    }
}
