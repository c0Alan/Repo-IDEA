#!/bin/sh

### 离线安装mysql, 参考: https://www.cnblogs.com/dandelion200/p/14525232.html

script_dir="/opt/script/mysql"
package_dir=${script_dir}/package
mkdir -p ${package_dir}

cd ${package_dir}

# 卸载Mariadb
# 找到数据库mariadb，如果有会给出一个结果，结果是mariadb名称
rpm -qa | grep mariadb
# 如果存在就卸载
# rpm -e --nodeps [mariadb名称]

# 卸载mysql
rpm -qa | grep mysql
# rpm -e --nodeps mysql文件名

tar xvf mysql-5.7.37-1.el7.x86_64.rpm-bundle.tar

rpm -ivh mysql-community-common-5.7.37-1.el7.x86_64.rpm
rpm -ivh mysql-community-libs-5.7.37-1.el7.x86_64.rpm
rpm -ivh mysql-community-devel-5.7.37-1.el7.x86_64.rpm
rpm -ivh mysql-community-libs-compat-5.7.37-1.el7.x86_64.rpm
rpm -ivh mysql-community-client-5.7.37-1.el7.x86_64.rpm
rpm -ivh mysql-community-server-5.7.37-1.el7.x86_64.rpm

# 启动MySQL
systemctl start mysqld

# 获取MySQL临时密码
grep 'temporary password' /var/log/mysqld.log >> ${script_dir}/password.txt

