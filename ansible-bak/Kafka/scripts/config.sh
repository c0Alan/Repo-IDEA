#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}/config

# 指定服务的端口
echo "" >> server.properties
sed -i "/^listeners=/d" server.properties
echo "listeners=$listeners" >> server.properties

sed -i "/^log.dirs=/d" server.properties
echo "log.dirs=$logDirs" >> server.properties

sed -i "/^broker.id=/d" server.properties
echo "broker.id=$brokerId" >> server.properties

sed -i "/^advertised.listeners=/d" server.properties
echo "advertised.listeners=$advertisedListeners" >> server.properties

sed -i "/^zookeeper.connect=/d" server.properties
echo "zookeeper.connect=$zookeeperConnect" >> server.properties
