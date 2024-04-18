#!/bin/bash

# CentOS 6 系统默认 Python 版本是：2.6.6 平时在使用中遇到很多的库要求是 2.7.x 版本的库

yum install vim gcc make wget -y
yum install openssl-devel zlib-devel readline-devel sqlite-devel -y
cd /usr/local/src
wget https://www.python.org/ftp/python/2.7.10/Python-2.7.10.tgz
tar -zxvf Python-2.7.10.tgz
cd Python-2.7.10
./configure --enable-shared --enable-loadable-sqlite-extensions --prefix=/usr/local/python27 --with-zlib --with-ssl

sed -i 's/#zlib zlibmodule.c -I$(prefix)\/include -L$(exec_prefix)\/lib -lz/zlib zlibmodule.c -I$(prefix)\/include -L$(exec_prefix)\/lib -lz/' ./Modules/Setup
make && make install

cd /usr/bin/
mv /usr/bin/python /usr/bin/python2.6.6
ln -s /usr/local/python27/bin/python2.7 /usr/bin/python

# python -V, 如果出现错误python: error while loading shared libraries: libpython2.7.so.1.0, 执行下面命令
echo /usr/local/python27/lib >> /etc/ld.so.conf
ldconfig

# yum, 如果报错There was a problem importing one of the Python modules, 执行下面命令
# 因为 yum 是不兼容 Python 2.7 的，所以 yum 不能正常工作，我们需要指定 yum 的 Python 为 2.6
sed -i 's/#!\/usr\/bin\/python/#!\/usr\/bin\/python2.6.6/' /usr/bin/yum

# 升级 python 后，安装 pip 工具
wget https://bootstrap.pypa.io/get-pip.py
python get-pip.py
ln -s /usr/local/python27/bin/pip2.7 /usr/bin/pip

# 安装 ipython
pip install ipython==1.2.1
ln -s /usr/local/python27/bin/ipython /usr/bin/ipython

