#!/bin/sh

# 参考: https://www.cnblogs.com/tony-hyn/p/15777762.html
script_dir="/opt/script/mysql"
package_dir=${script_dir}/package
mkdir -p ${package_dir}

cd ${package_dir}
# 在线下载mysql安装包
wget https://dev.mysql.com/get/mysql57-community-release-el7-8.noarch.rpm
# 安装MySQL
rpm -ivh mysql57-community-release-el7-8.noarch.rpm

# 安装mysql服务
cd /etc/yum.repos.d/
yum -y install mysql-server

# 启动MySQL
systemctl start mysqld

# 获取MySQL临时密码
grep 'temporary password' /var/log/mysqld.log > ${script_dir}/password.txt

