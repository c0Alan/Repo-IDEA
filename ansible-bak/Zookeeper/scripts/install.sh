#!/bin/bash

source ./publicVar.sh

mkdir -p ${home}/data
echo ${myid} > ${home}/data/myid
mkdir -p ${home}/logs
cd ${home}
# wget ${downloadUrl}
tar -zxvf ${package}

sed -i '/ZOOKEEPER_HOME/d' ~/.bashrc
echo '# 配置 ZOOKEEPER_HOME 环境变量' >> ~/.bashrc
echo export ZOOKEEPER_HOME=${home}/${packageDir} >> ~/.bashrc
echo 'export PATH=$PATH:$ZOOKEEPER_HOME/bin' >> ~/.bashrc
source ~/.bashrc
