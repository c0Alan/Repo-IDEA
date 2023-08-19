#!/bin/sh

# 参考: https://blog.csdn.net/wdy0078/article/details/121902965
script_dir="/opt/script/nginx"
package_dir=${script_dir}/package
mkdir -p ${package_dir}


cd ${package_dir}
wget http://nginx.org/download/nginx-1.21.6.tar.gz
yum -y install gcc pcre-devel zlib-devel openssl openssl-devel

#解压
tar -zxvf nginx-1.21.6.tar.gz

#进入NG目录
cd ./nginx-1.21.6

#配置
./configure --prefix=/usr/local/nginx

#编译
make
make install

# systemctl配置
cp ${script_dir}/nginx.service /etc/systemd/system



