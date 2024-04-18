#!/bin/bash
# 关闭防火墙

#disable firewalld
systemctl stop firewalld.service && systemctl disable firewalld.service

# systemctl start firewalld.service && systemctl enable firewalld.service

#disable selinux
setenforce 0
sed -i "s/^SELINUX\=enforcing/SELINUX\=disabled/g" /etc/selinux/config
