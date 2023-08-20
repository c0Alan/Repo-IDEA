#!/bin/sh

##### 关闭防火墙, 参考: https://www.cnblogs.com/xiaoluohao/p/13291649.html


echo "关闭防火墙"
# 临时关闭防火墙
systemctl stop firewalld

# 永久关闭防火墙，禁止开机启动
systemctl disable firewalld

echo "关闭selinux"
sed -i -e "s/SELINUX=enforcing/disabled/" /etc/selinux/config

echo "设置时区"
timedatectl set-timezone "Asia/Shanghai"
