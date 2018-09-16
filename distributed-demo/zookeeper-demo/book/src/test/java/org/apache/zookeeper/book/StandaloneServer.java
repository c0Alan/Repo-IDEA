package org.apache.zookeeper.book;

import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig.ConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Starts a ZooKeeper standalone server. Mostly copied from the 
 * ZooKeeper distribution.
 */

public class StandaloneServer extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(StandaloneServer.class);
   
    final File confFile;
    final TestZKSMain main;
    
    
    /*
     * Mock implementation of ZooKeeper Server.
     */
    public static class TestZKSMain extends ZooKeeperServerMain {
        public void initializeAndRun(String[] args)
        throws ConfigException, IOException {
            super.initializeAndRun(args);
        }
        public void shutdown() {
            super.shutdown();
        }
    }

    public StandaloneServer(File confFile)
    throws IOException {
        this.confFile = confFile;
        main = new TestZKSMain();
    }
    
    public StandaloneServer(int clientPort, File tmpDir) throws IOException {
        super("Standalone server with clientPort:" + clientPort);
        confFile = new File(tmpDir, "zoo.cfg");
        
        FileWriter fwriter = new FileWriter(confFile);
        fwriter.write("tickTime=2000\n");
        fwriter.write("initLimit=10\n");
        fwriter.write("syncLimit=5\n");
        
        File dataDir = new File(tmpDir, "data");
        if (!dataDir.mkdir()) {
            throw new IOException("unable to mkdir " + dataDir);
        }
            
        // Convert windows path to UNIX to avoid problems with "\"
        String dir = dataDir.toString();
        String osname = System.getProperty("os.name");
        if (osname.toLowerCase().contains("windows")) {
            dir = dir.replace('\\', '/');
        }
        fwriter.write("dataDir=" + dir + "\n");
            
        fwriter.write("clientPort=" + clientPort + "\n");
        fwriter.flush();
        fwriter.close();

        main = new TestZKSMain();
    }

    public void run() {
        String args[] = new String[1];
        args[0] = confFile.toString();
        try {
            main.initializeAndRun(args);
        } catch (Exception e) {
            // test will still fail even though we just log/ignore
            LOG.error("unexpected exception in run: " + e);
        }
    }

    public void shutdown() {     
        main.shutdown();
        interrupt();
    }
}
