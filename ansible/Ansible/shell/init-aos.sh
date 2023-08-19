#!/bin/bash

if [ -f "init.txt" ];then
	echo "已经初始化..."
	exit 0
fi

echo "首次运行, 安装初始化..."

path=`pwd`

#disable firewalld
systemctl stop firewalld.service
systemctl disable firewalld.service

echo "关闭防火墙" >> init.txt

#disable selinux
setenforce 0
sed -i "s/^SELINUX\=enforcing/SELINUX\=disabled/g" /etc/selinux/config

echo "关闭SELINUX" >> init.txt

#tar packages
# tar -xzvf  ${path}/setupPackages.tar.gz

#chmod +x for unpackage files
chmod 555 ${path}/* -R

#setup ansible
rpm -Uvh ${path}/ansible_installpackage/*.rpm --nodeps --force

echo "安装ansible" >> init.txt

echo "安装 JDK 1.8 ..."
#setup JDK 1.8
rpm -ihv ${path}/ansible-aos/resources/jdk-8u60-linux-x64.rpm

echo "安装 JDK 1.8" >> init.txt

echo "安装 MySQL ..."
echo "开始安装MySQL" >> init.txt
cd ansible-aos && ansible-playbook mysql_install.yml -i db.ini --skip-tags=start,stop -vv > logs/mysql_install.log 2>&1

echo "启动 MySQL ..."
echo "启动MySQL" >> ../init.txt
ansible-playbook mysql_install.yml -i db.ini --tags=start -vv > logs/mysql_start.log 2>&1

service mysqld stop
systemctl start mysqld.service

echo "初始化完成!"
echo "初始化完成!" >> ../init.txt

echo "启动自动化运维系统!"
echo "启动自动化运维系统!" >> ../init.txt
cd ..
./startupTomcat.sh

echo "自动化运维系统启动完成!"
echo "自动化运维系统启动完成!" >> ../init.txt
