#!/bin/bash

echo "服务器初始化"
ansible-playbook -i hosts init.yml -vv

echo ""
echo "安装 jdk"
ansible-playbook -i hosts jdk.yml -vv

echo ""
echo "安装 nginx"
ansible-playbook -i hosts nginx.yml -vv

echo ""
echo "安装 mysql"
ansible-playbook -i hosts mysql.yml -vv

echo ""
echo "安装 nacos"
ansible-playbook -i hosts nacos.yml -vv



