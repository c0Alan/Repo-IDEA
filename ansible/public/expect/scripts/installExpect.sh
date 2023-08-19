#!/bin/bash

source ./publicVar.sh

# expect是在tcl基础上创建起来的，因此在安装expect之前需要安装tcl

# 安装TCL
cd $home

# wget ${downloadTclUrl}
tar -xzvf ${tclPackage}
cd ${tclPackageDir}/unix/
./configure --prefix=/usr/tcl --enable-shared
make
make install

cd $home
# 安装expect
# wget ${downloadUrl}
tar -xzvf ${package}
cd ${packageDir}
./configure --prefix=/usr/expect --with-tcl=/usr/tcl/lib --with-tclinclude=../tcl8.5.19/generic
make
make install
ln -s /usr/tcl/bin/expect /usr/expect/bin/expect
cp /usr/expect/bin/expect /usr/bin/

cd $home
rm -rf expect5.45
rm -rf tcl8.5.19
# rm -f expect5.45.tar.gz
# rm -f tcl8.5.19-src.tar.gz
