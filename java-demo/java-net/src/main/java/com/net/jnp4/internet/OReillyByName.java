package com.net.jnp4.internet;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import java.net.*;
import java.util.Arrays;

public class OReillyByName {
    private static Logger logger = Logger.getLogger(OReillyByName.class);

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.oreilly.com");
            InetAddress[] addresses = InetAddress.getAllByName("www.oreilly.com");
            System.out.println(address); // www.oreilly.com/23.53.203.195
            logger.info(Arrays.asList(addresses)); // [www.oreilly.com/23.53.203.195]
        } catch (UnknownHostException ex) {
            System.out.println("Could not find www.oreilly.com");
        }
    }
}
