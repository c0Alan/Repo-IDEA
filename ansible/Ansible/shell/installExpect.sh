#!/bin/bash

sourcePath='/tmp'

# expect是在tcl基础上创建起来的，因此在安装expect之前需要安装tcl

# 安装TCL
cd $sourcePath

wget http://prdownloads.sourceforge.net/tcl/tcl8.5.19-src.tar.gz
tar -xzvf tcl8.5.19-src.tar.gz
cd tcl8.5.19/unix/
./configure --prefix=/usr/tcl --enable-shared
make
make install

cd $sourcePath
# 安装expect
wget http://nchc.dl.sourceforge.net/project/expect/Expect/5.45/expect5.45.tar.gz 
tar -xzvf expect5.45.tar.gz
cd expect5.45
./configure --prefix=/usr/expect --with-tcl=/usr/tcl/lib --with-tclinclude=../tcl8.5.19/generic
make
make install
ln -s /usr/tcl/bin/expect /usr/expect/bin/expect
cp /usr/expect/bin/expect /usr/bin/

rm -rf /tmp/expect5.45
rm -rf /tmp/tcl8.5.19
rm -f expect5.45.tar.gz
rm -f tcl8.5.19-src.tar.gz