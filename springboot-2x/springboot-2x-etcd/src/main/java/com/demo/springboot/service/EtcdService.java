package com.demo.springboot.service;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.kv.GetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author liuxilin
 * @date 2022年05月13日 10:26
 */
@Slf4j
@Service
public class EtcdService {
    @Autowired
    Client etcdClient;

    public String getValue(String key) throws ExecutionException, InterruptedException {
        KV kvClient = etcdClient.getKVClient();
        ByteSequence bKey = ByteSequence.from(key.getBytes());
        CompletableFuture<GetResponse> getFuture = kvClient.get(bKey);
        GetResponse response = getFuture.get();
        System.out.println("查询结果: " + response);
        return response.toString();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testEtcd();
    }

    public static void testEtcd() throws ExecutionException, InterruptedException {
        // create client using endpoints
        Client client = Client.builder().endpoints("http://172.25.20.57:2379").build();

        KV kvClient = client.getKVClient();
        ByteSequence key = ByteSequence.from("test_key".getBytes());
        ByteSequence value = ByteSequence.from("test_value".getBytes());

        // put the key-value
        kvClient.put(key, value).get();

        // get the CompletableFuture
        CompletableFuture<GetResponse> getFuture = kvClient.get(key);

        // get the value from CompletableFuture
        GetResponse response = getFuture.get();

        System.out.println("查询结果: " + response);

        ByteSequence key2 = ByteSequence.from("foo".getBytes());
        getFuture = kvClient.get(key2);
        response = getFuture.get();

        System.out.println("查询结果2: " + response);


        // delete the key
//        kvClient.delete(key).get();

        client.close();
    }
}
