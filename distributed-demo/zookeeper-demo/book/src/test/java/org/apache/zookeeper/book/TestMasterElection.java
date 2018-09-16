package org.apache.zookeeper.book;

import com.zookeeper.watcher.Master;
import com.zookeeper.watcher.Master.MasterStates;
import org.junit.Test;
import org.junit.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMasterElection extends BaseTestCase {    
    private static final Logger LOG = LoggerFactory.getLogger(TestMasterElection.class);
    
    @Test(timeout=50000)
    public void electMaster() 
    throws Exception {
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
        
        Assert.assertTrue("Master not elected.", m.getState() == MasterStates.ELECTED);
        m.close();
    }
    
    @Test(timeout=50000)
    public void reElectMaster() 
    throws Exception {
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
        
        m.close();
        
        Master bm = new Master("localhost:" + port);
        bm.startZK();
        
        while(!bm.isConnected()){
            Thread.sleep(500);
        }
        
        bm.bootstrap();
        bm.runForMaster();
        
        while(bm.getState() == MasterStates.RUNNING){
            Thread.sleep(100);
        }
          
        Assert.assertTrue("Master not elected.", bm.getState() == MasterStates.ELECTED);
        bm.close();
    }
    
    @Test(timeout=50000)
    public void electSingleMaster() 
    throws Exception {
        Master m = new Master("localhost:" + port);
        Master bm = new Master("localhost:" + port);
        m.startZK();
        bm.startZK();
        
        while(!m.isConnected() || !bm.isConnected()){
            Thread.sleep(500);
        }
        
        m.bootstrap();
        bm.bootstrap();
        
        m.runForMaster();
        bm.runForMaster();
        
        while((m.getState() == MasterStates.RUNNING) ||
                (bm.getState() == MasterStates.RUNNING)){
            Thread.sleep(100);
        }
        
        boolean singleMaster = (((m.getState() == MasterStates.ELECTED) 
                        && (bm.getState() != MasterStates.ELECTED)) 
                || ((m.getState() != MasterStates.ELECTED) 
                        && (bm.getState() == MasterStates.ELECTED)));
        Assert.assertTrue("Master not elected.", singleMaster);
        m.close();
    }
    
    @Test(timeout=50000)
    public void testMasterExists() 
    throws Exception {
        Master m = new Master("localhost:" + port);

        m.startZK();
        
        while(!m.isConnected()){
            Thread.sleep(500);
        }
        
        m.bootstrap();
        m.masterExists();
        
        int attempts = 10;
        boolean elected = true;
        while((m.getState() == MasterStates.RUNNING)){
            Thread.sleep(200);
            if(attempts-- == 0) {
                LOG.info("Breaking...");
                elected = false;
                break;
            }
        }
        
        Assert.assertTrue("Master not elected.", elected);
        m.close();
    }
    
}
