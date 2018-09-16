package org.apache.zookeeper.book;

import com.zookeeper.watcher.Master;
import com.zookeeper.watcher.Master.MasterStates;
import com.zookeeper.watcher.Worker;
import org.junit.Test;

public class TestWorkerChanges extends BaseTestCase {


    @Test(timeout = 50000)
    public void addWorker() throws Exception {
        Master m = new Master("localhost:" + port);
        m.startZK();

        while (!m.isConnected()) {
            Thread.sleep(500);
        }

        m.bootstrap();
        m.runForMaster();

        while (m.getState() == MasterStates.RUNNING) {
            Thread.sleep(100);
        }

        Worker w = new Worker("localhost:" + port);
        w.startZK();

        while (!w.isConnected()) {
            Thread.sleep(100);
        }

        /*
         * bootstrap() create some necessary znodes.
         */
        w.bootstrap();

        /*
         * Registers this worker so that the leader knows that
         * it is here.
         */
        w.register();

        while (m.getWorkersSize() == 0) {
            Thread.sleep(100);
        }
    }

}
