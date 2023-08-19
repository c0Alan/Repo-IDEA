#!/bin/sh

# 离线安装配置etcd

cd "/opt"
unzip etcd.zip
sh etcd/install.sh

echo 'export ETCD_HOME=/opt/etcd' >> /etc/profile
echo 'export PATH=${ETCD_HOME}:$PATH' >> /etc/profile
source /etc/profile
