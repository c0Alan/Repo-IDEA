#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}/config

# 设置集群名称，集群内所有节点的名称必须一致。
sed -i "/^cluster.name:/d" elasticsearch.yml
echo "cluster.name: $clusterName" >> elasticsearch.yml

# 设置节点名称，集群内节点名称必须唯一。
sed -i "/^node.name:/d" elasticsearch.yml
echo "node.name: $nodeName" >> elasticsearch.yml

# 表示该节点会不会作为主节点，true表示会；false表示不会
sed -i "/^node.master:/d" elasticsearch.yml
echo "node.master: $nodeMaster" >> elasticsearch.yml

# 当前节点是否用于存储数据，是：true、否：false
sed -i "/^node.data:/d" elasticsearch.yml
echo "node.data: $nodeData" >> elasticsearch.yml

# 索引数据存放的位置
sed -i "/^path.data:/d" elasticsearch.yml
echo "path.data: ${home}/data" >> elasticsearch.yml

# 日志文件存放的位置
sed -i "/^path.logs:/d" elasticsearch.yml
echo "path.logs: ${home}/logs" >> elasticsearch.yml

# 监听地址，用于访问该es
sed -i "/^network.host:/d" elasticsearch.yml
echo "network.host: $localIp" >> elasticsearch.yml

# es对外提供的http端口，默认 9200
# sed -i "/^http.port:/d" elasticsearch.yml
# echo "http.port: $httpPort" >> elasticsearch.yml

# TCP的默认监听端口，默认 9300
# sed -i "/^transport.tcp.port:/d" elasticsearch.yml
# echo "transport.tcp.port: $transportTcpPort" >> elasticsearch.yml

# es7.x 之后新增的配置，写入候选主节点的设备地址，在开启服务后可以被选为主节点
sed -i "/^discovery.seed_hosts:/d" elasticsearch.yml
echo "discovery.seed_hosts: $seed_hosts" >> elasticsearch.yml

# es7.x 之后新增的配置，初始化一个新的集群时需要此配置来选举master
sed -i "/^cluster.initial_master_nodes:/d" elasticsearch.yml
echo "cluster.initial_master_nodes: $initial_master_nodes" >> elasticsearch.yml

# 是否支持跨域，是：true，在使用head插件时需要此配置
sed -i "/^http.cors.enabled:/d" elasticsearch.yml
echo "http.cors.enabled: $httpCorsEnabled" >> elasticsearch.yml

# “*” 表示支持所有域名
sed -i "/^http.cors.allow-origin:/d" elasticsearch.yml
echo "http.cors.allow-origin: $httpCorsAllowOrigin" >> elasticsearch.yml
