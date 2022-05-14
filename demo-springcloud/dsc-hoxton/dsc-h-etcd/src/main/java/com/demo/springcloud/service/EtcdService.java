package com.demo.springcloud.service;

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
        return response.toString();
    }
}
