#!/bin/bash

source ./publicVar.sh

chown -R es:es ${home}

cd ${home}/${packageDir}/config

# 监听端口
sed -i "/^server.port:/d" kibana.yml
echo "server.port: $serverPort" >> kibana.yml

# 监听IP地址，建议内网ip
sed -i "/^server.host:/d" kibana.yml
echo "server.host: $serverHost" >> kibana.yml

# elasticsearch连接kibana的URL，集群任一节点
sed -i "/^elasticsearch.hosts:/d" kibana.yml
echo "elasticsearch.hosts: $elasticsearchHosts" >> kibana.yml

