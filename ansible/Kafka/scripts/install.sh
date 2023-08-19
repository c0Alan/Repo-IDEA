#!/bin/bash

source ./publicVar.sh

mkdir -p ${logDirs}
cd ${home}
# wget ${downloadUrl}
tar -zxvf ${package}

sed -i '/KAFKA_HOME/d' ~/.bashrc
echo '# 配置 KAFKA_HOME 环境变量' >> ~/.bashrc
echo export KAFKA_HOME=${home}/${packageDir} >> ~/.bashrc
echo 'export PATH=$PATH:$KAFKA_HOME/bin' >> ~/.bashrc
source ~/.bashrc

