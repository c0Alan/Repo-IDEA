#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}/conf

# zk集群
echo "" >> application.conf
sed -i "/^kafka-manager.zkhosts=/d" application.conf
echo "kafka-manager.zkhosts=$zkhosts" >> application.conf

