package org.apache.zookeeper.book;

import com.zookeeper.watcher.Master;
import com.zookeeper.watcher.Master.MasterStates;
import com.zookeeper.watcher.Worker;
import org.apache.zookeeper.book.Client.TaskObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TestTaskAssignment extends BaseTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(TestTaskAssignment.class);
    
    @Test(timeout=50000)
    public void taskAssignmentSequential() throws Exception {
        LOG.info("Starting master - Sequential");
        Master m = new Master("localhost:" + port);
        m.startZK();
        
        while(!m.isConnected()){
            Thread.sleep(500);
        }
        
        m.bootstrap();
        m.runForMaster();
        
        while(m.getState() == MasterStates.RUNNING){
            Thread.sleep(100);
        }
        
        LOG.info("Starting worker");
        Worker w1 = new Worker("localhost:" + port);
        Worker w2 = new Worker("localhost:" + port);
        Worker w3 = new Worker("localhost:" + port);
        
        w1.startZK();
        w2.startZK();
        w3.startZK();
        
        while(!w1.isConnected() && !w2.isConnected() && !w3.isConnected()){
            Thread.sleep(100);
        }   
        
        /*
         * bootstrap() create some necessary znodes.
         */
        w1.bootstrap();
        w2.bootstrap();
        w3.bootstrap();
        
        /*
         * Registers this worker so that the leader knows that
         * it is here.
         */
        w1.register();        
        w1.getTasks();
        
        w2.register();        
        w2.getTasks();
        
        w3.register();        
        w3.getTasks();
        
        LOG.info("Starting client");
        Client c = new Client("localhost:" + port);
        c.startZK();
        
        while(!c.isConnected() &&
                w1.isConnected() &&
                w2.isConnected() &&
                w3.isConnected()){
            Thread.sleep(100);
        }   
        
        
        TaskObject task = null;
        for(int i = 1; i < 200; i++) {
            task = new TaskObject();   
            c.submitTask("Sample task", task);
            task.waitUntilDone();
            Assert.assertTrue("Task not done", task.isDone());
        }
        
        m.close();
        w1.close();
        w2.close();
        w3.close();
        c.close();
    }
    
    @Test(timeout=50000)
    public void taskAssignmentParallel() throws Exception {
        LOG.info("Starting master - Parallel");
        Master m = new Master("localhost:" + port);
        m.startZK();
        
        while(!m.isConnected()){
            Thread.sleep(500);
        }
        
        m.bootstrap();
        m.runForMaster();
        
        while(m.getState() == MasterStates.RUNNING){
            Thread.sleep(100);
        }
        
        LOG.info("Starting worker");
        Worker w1 = new Worker("localhost:" + port);
        Worker w2 = new Worker("localhost:" + port);
        Worker w3 = new Worker("localhost:" + port);
        
        w1.startZK();
        w2.startZK();
        w3.startZK();
        
        while(!w1.isConnected() && !w2.isConnected() && !w3.isConnected()){
            Thread.sleep(100);
        }   
        
        /*
         * bootstrap() create some necessary znodes.
         */
        w1.bootstrap();
        w2.bootstrap();
        w3.bootstrap();
        
        /*
         * Registers this worker so that the leader knows that
         * it is here.
         */
        w1.register();        
        w1.getTasks();
        
        w2.register();        
        w2.getTasks();
        
        w3.register();        
        w3.getTasks();
        
        LOG.info("Starting client");
        Client c = new Client("localhost:" + port);
        c.startZK();
        
        while(!c.isConnected() &&
                w1.isConnected() &&
                w2.isConnected() &&
                w3.isConnected()){
            Thread.sleep(100);
        }   
        
        
        ArrayList<TaskObject> tasks = new ArrayList<TaskObject>();
        for(int i = 1; i < 200; i++) {
            TaskObject task = new TaskObject();   
            c.submitTask("Sample task", task);
        }
        
        for(TaskObject task: tasks) {
            task.waitUntilDone();
            Assert.assertTrue("Task not done", task.isDone());
        }
        
        
        m.close();
        w1.close();
        w2.close();
        w3.close();
        c.close();
    }
    
    @Test(timeout=50000)
    public void taskZooKeeperCrash() throws Exception {
        LOG.info("Starting master - ZooKeeper Crash");
        Master m = new Master("localhost:" + port);
        m.startZK();
            
        while(!m.isConnected()){
            Thread.sleep(500);
        }
            
        m.bootstrap();
            
        LOG.info("Starting worker");
        Worker w1 = new Worker("localhost:" + port);
        Worker w2 = new Worker("localhost:" + port);
        Worker w3 = new Worker("localhost:" + port);
            
        w1.startZK();
        w2.startZK();
        w3.startZK();
            
        while(!w1.isConnected() && !w2.isConnected() && !w3.isConnected()){
            Thread.sleep(100);
        }   
            
        /*
         * bootstrap() create some necessary znodes.
         */
        w1.bootstrap();
        w2.bootstrap();
        w3.bootstrap();
            
        /*
         * Registers this worker so that the leader knows that
         * it is here.
         */
        w1.register();        
        w1.getTasks();
        
        w2.register();        
        w2.getTasks();
        
        w3.register();        
        w3.getTasks();
            
        LOG.info("Starting client");
        Client c = new Client("localhost:" + port);
        c.startZK();
            
        while(!c.isConnected() &&
                w1.isConnected() &&
                w2.isConnected() &&
                w3.isConnected()){
            Thread.sleep(100);
        }   
            
            
        TaskObject task = null;
        for(int i = 1; i < 200; i++) {
            task = new TaskObject();   
            c.submitTask("Sample task", task);
        }

        
        /*
         * Restart ZooKeeper server
         */
        restartServer();
        LOG.info( "ZooKeeper server restarted" );
        
        /*
         * Let's start a new master
         */
        m.runForMaster();
            
        /*
         * ... and wait until the master is up
         */
        while(m.getState() == MasterStates.RUNNING){
            Thread.sleep(100);
        }       
        
        if(task != null) {
            LOG.info( "Task I'm waiting for: " + task.getTaskName() );
            task.waitUntilDone();
        } else {
            LOG.error("Task is null.");
        }
            
        m.close();
        w1.close();
        w2.close();
        w3.close();
        c.close();
    }
}
