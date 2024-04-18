#!/bin/bash

echo "服务器初始化"
ansible-playbook -i hosts init.yml

echo ""
echo "安装 jdk"
ansible-playbook -i hosts jdk.yml

echo ""
echo "安装 nginx"
ansible-playbook -i hosts nginx.yml

