#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}/config

# 删除原有配置
sed -i "/^network.host:/d" elasticsearch.yml
sed -i "/#network.host/anetwork.host: $localIp" elasticsearch.yml

sed -i "/^http.port:/d" elasticsearch.yml
sed -i "/#http.port/ahttp.port: $port" elasticsearch.yml

sed -i "/^cluster.initial_master_nodes:/d" elasticsearch.yml
sed -i "/#cluster.initial_master_nodes/acluster.initial_master_nodes: [\"$initial_master_nodes\"]" elasticsearch.yml