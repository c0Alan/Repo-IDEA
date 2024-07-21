package com.demo.java.apachecommons.net.program;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.ArrayUtils;

/**
 * <Java网络编程从入门到精通>  测试类 : http://www.blogjava.net/nokiaguy/category/38517.html?Show=All
 * 
 * @author liuxl
 * 2017-11-18 上午10:46:41
 */
public class NetProgram {
    /**
     * （2）：创建InetAddress对象的四个静态方法
     * @throws UnknownHostException
     * @author liuxl
     * @date @time 2017-11-18 上午10:43:00
     */
    @SuppressWarnings("unused")
    public static void chapter02() throws UnknownHostException {
        /** 测试InetAddress对象的四个静态方法 */
        InetAddress localAddress = InetAddress.getLocalHost(); // DESKTOP-ODSRILJ/192.168.12.99

        localAddress = InetAddress.getByName("www.baidu.com"); // www.csdn.net/101.201.172.229

        InetAddress addresses[] = InetAddress.getAllByName("www.baidu.com"); // {www.baidu.com/183.232.231.172,www.baidu.com/183.232.231.173}

        addresses = InetAddress.getAllByName("www.oracle.com"); // {www.oracle.com/223.119.215.103}
        System.out.println(ArrayUtils.toString(addresses));
        /**
         * IP地址必须是byte数组形式
         * host 只是一个用于表示addr的别名
         */
        byte ip[] = new byte[] { (byte) 141, (byte) 146, 8, 66 };
        InetAddress address1 = InetAddress.getByAddress(ip); // /141.146.8.66
        InetAddress address2 = InetAddress.getByAddress("Oracle官方网站", ip); // Oracle官方网站/141.146.8.66
    }

    /**
     * （3）：为什么不能直接通过IP访问网站
     * 
     * @author liuxl
     * @throws UnknownHostException 
     * @date @time 2017-11-18 上午10:52:55
     */
    @SuppressWarnings("unused")
    public static void chapter03() throws UnknownHostException {
        /**
         * badiu: http://183.232.231.172, http://183.232.231.173 都是可以访问到百度的网站的, 如果有的网站不能访问, 那就是在服务端被禁了
         * csdn: http://101.201.172.229 无法访问, 服务端对此做了限制
         * HTTP协议请求头有一个Host字段, www.csdn.net的服务器通过检测Host字段防止客户端直接使用IP进行访问。 目前有很多网站，如www.sina.com.cn、www.126.com都是这样做的。
         * 有一些网站虽然未限制用IP地址来访问，但在使用IP地址访问网站时，却将IP地址又重定位到相应的域名上. 如输入http://141.146.8.66会重定位到http://www.oracle.com/index.html上.
         * 
         */
        InetAddress addresses[] = InetAddress.getAllByName("www.baidu.com"); // {www.baidu.com/183.232.231.172,www.baidu.com/183.232.231.173}
        InetAddress addresses2[] = InetAddress.getAllByName("www.csdn.net"); // {www.csdn.net/101.201.172.229}

    }

    /**
     * （4）：DNS缓存
     * 
     * @author liuxl
     * @throws IOException 
     * @throws InterruptedException 
     * @date @time 2017-11-18 上午10:52:55
     */
    public static void chapter04() throws IOException, InterruptedException {
        /**
         * 在通过DNS查找域名的过程中，可能会经过多台中间DNS服务器才能找到指定的域名，因此，在DNS服务器上查找域名是非常昂贵的操作。
         * 当InetAddress类第一次使用某个域名（如www.csdn.net）创建InetAddress对象后，JVM就会将这个域名和它从DNS上获得的信息（如IP地址）都保存在DNS缓存中。
         * 当下一次InetAddress类再使用这个域名时，就直接从DNS缓存里获得所需的信息，而无需再访问DNS服务器。
         */
        java.security.Security.setProperty("networkaddress.cache.ttl", "5"); // 设置 DNS 缓存时间为 5 秒, -1 为设置缓存永不过期
        long time = System.currentTimeMillis();
        InetAddress addresses1[] = InetAddress.getAllByName("www.126.com"); // 走 DNS 服务器
        System.out.println("addresses1:   " + String.valueOf(System.currentTimeMillis() - time) + "毫秒");
        for (InetAddress address : addresses1)
            System.out.println(address);
        System.out.print("按任意键继续");
        System.in.read();
        time = System.currentTimeMillis();
        InetAddress addresses2[] = InetAddress.getAllByName("www.126.com"); // 5秒内 走 DNS 缓存
        System.out.println("addresses2:   " + String.valueOf(System.currentTimeMillis() - time) + "毫秒");
        for (InetAddress address : addresses2)
            System.out.println(address);

        /**
         * 如果域名在DNS服务器上不存在，那么客户端在进行一段时间的尝试后（平均为5秒），就会抛出一个UnknownHostException异常。
         * 为了让下一次访问这个域名时不再等待，DNS缓存将这个错误信息也保存了起来。
         * 也就是说，只有第一次访问错误域名时才进行5称左右的尝试，以后再访问这个域名时将直接抛出UnknownHostException异常，而无需再等待5秒钟，
         * 访问域名失败的原因可能是这个域名真的不存在，也可能是因为DNS服务器或是其他的硬件或软件的临时故障，
         * 因此，一般不能将这个域名错误信息一直保留。在Java中可以通过networkaddress.cache.negative.ttl属性设置保留这些信息的时间。
         * 这个属性的默认值是10秒。它也可以通过java.security.Security.setProperty方法或java.security文件来设置。
         * 下面的代码演示了networkaddress.cache.negative.ttl属性的用法：
         */
        java.security.Security.setProperty("networkaddress.cache.negative.ttl", "5");
        time = 0;
        try {
            time = System.currentTimeMillis();
            InetAddress.getByName("www.ppp123aaa.com");
        } catch (Exception e) {
            System.out.println("www.ppp123aaa.com不存在! address1: " + String.valueOf(System.currentTimeMillis() - time)
                    + "毫秒");
        }
        //Thread.sleep(6000); // 5秒内走缓存, 6秒后缓存被释放
        try {
            time = System.currentTimeMillis();
            InetAddress.getByName("www.ppp123aaa.com");
        } catch (Exception e) {
            System.out.println("www.ppp123aaa.com不存在! address2: " + String.valueOf(System.currentTimeMillis() - time)
                    + "毫秒");
        }

        /**
         * 在使用DNS缓存时有两点需要注意：
         * 1. 可以根据实际情况来设置networkaddress.cache.ttl属性的值。一般将这个属性的值设为-1。
         *  但如果访问的是动态映射的域名（如使用动态域名服务将域名映射成ADSL的动态IP）, 就可能产生IP地址变化后，客户端得到的还是原来的IP地址的情况。
         * 2. 在设置networkaddress.cache.negative.ttl属性值时最好不要将它设为-1，否则如果一个域名因为暂时的故障而无法访问，
         *  那么程序再次访问这个域名时，即使这个域名恢复正常，程序也无法再访问这个域名了。除非重新运行程序。
         */
    }

    /**
     * （5）：使用InetAddress类的getHostName方法获得域名
     * @throws UnknownHostException
     * @author liuxl
     * @date @time 2017-11-21 下午12:13:07
     */
    public static void chapter05() throws UnknownHostException {

        /** 1．使用getLocalHost方法创建InetAddress对象 */
        InetAddress address = InetAddress.getLocalHost();
        //        System.out.println(address.getHostName()); // 输出本机名

        /** 2．使用域名创建InetAddress对象 */
        address = InetAddress.getByName("www.oracle.com");
        //        System.out.println(address.getHostName()); // 无需访问DNS服务器，直接返回域名

        /** 3．使用IP地址创建InetAddress对象 */
        address = InetAddress.getByName("141.146.8.66");
        //        System.out.println(address.getHostName()); // 需要访问DNS服务器才能得到域名
        address = InetAddress.getByName("1.2.3.4"); // IP地址不存在
        //        System.out.println(address.getHostName()); // 直接返回IP地址

        /**
         * 从上面的三种情况可以看出，只有通过使用IP地址创建的InetAddress对象调用getHostName方法时才访问DNS服务器。
         * 在其他情况，getHostName方法并不会访问DNS服务器，而是直接将域名或本机名返回。
         */

        long time = 0;
        // 得到本机名
        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println("本机名： " + address1.getHostName());
        // 直接返回域名
        InetAddress address2 = InetAddress.getByName("www.oracle.com");
        time = System.currentTimeMillis();
        System.out.print("直接得到域名： " + address2.getHostName());
        System.out.println("  所用时间：" + String.valueOf(System.currentTimeMillis() - time) + " 毫秒");
        // 通过DNS查找域名
        InetAddress address3 = InetAddress.getByName("223.119.215.103");
        System.out.println("address3:  " + address3); // 域名为空
        time = System.currentTimeMillis();
        System.out.print("通过DNS查找域名： " + address3.getHostName());
        System.out.println("  所用时间：" + String.valueOf(System.currentTimeMillis() - time) + " 毫秒");
        System.out.println("address3:  " + address3); // 同时输出域名和IP地址
    }

    /**
     * （6）：使用getCanonicalHostName方法获得主机名
     * @throws UnknownHostException
     * @author liuxl
     * @date @time 2017-11-21 下午8:14:18
     */
    public static void chapter06() throws UnknownHostException {
        outHostName(InetAddress.getLocalHost(), "getLocalHost方法");
        outHostName(InetAddress.getByName("www.ibm.com"), "www.ibm.com");
        outHostName(InetAddress.getByName("www.126.com"), "www.126.com");
        outHostName(InetAddress.getByName("202.108.9.77"), "202.108.9.77");
        outHostName(InetAddress.getByName("211.100.26.121"), "211.100.26.121");
        
        /**
         * 如果InetAddress对象是通过IP地址创建的，getCanonicalHostName方法和getHostName方法的值是完全一样的，它们的值可能是主机名，也可能是IP地址。
         * 而用域名创建的InetAddress对象就不一定了，它们的值可能相同（相同的IP地址或域名），也可能不相同，如上面运行结果中的www.126.com使用这两个方法得到的值就不同。
         * 我们可以使用getHostName来获得域名，因为如果使用域名来创建InetAddress对象，getHostName所得到的域名就是用来创建InetAddress对象的域名
         * 如果使用IP地址来创建InetAddress对象，getHostName方法等价于getCanonicalHostName方法
         */
    }

    public static void outHostName(InetAddress address, String s) {
        System.out.println("通过" + s + "创建InetAddress对象");
        System.out.println("主 机 名:" + address.getCanonicalHostName());
        System.out.println("主机别名:" + address.getHostName());
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        chapter06();
    }
}
