package org.apache.zookeeper.book;

import com.zookeeper.watcher.Master;
import org.junit.Test;

/**
 * @author liuxilin
 * @date 2018/8/19 16:48
 */
public class TestMaster {

    /**
     * zk 连接测试
     * @throws Exception
     */
    @Test
    public void testStart()
            throws Exception {
        String host = "192.168.80.80:2281";
        Master m = new Master(host);
        // session 断开之前不断尝试连接, 直到session断开
        m.startZK();
        // 1分钟后断开session
        Thread.sleep(60000);
    }
}
