#!/bin/bash

source ./publicVar.sh

# 删除 JAVA 环境变量
sed -i '/JAVA_HOME/d' /etc/profile

# 设置 JAVA 环境变量
echo '# 配置 JAVA_HOME 环境变量' >> /etc/profile
echo JAVA_HOME=${home}/${packageDir} >> /etc/profile
echo 'PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
echo 'export JAVA_HOME PATH' >> /etc/profile
# 使配置生效
source /etc/profile

sed -i '/JAVA_HOME/d' ~/.bashrc
echo '# 配置 JAVA_HOME 环境变量' >> ~/.bashrc
echo export JAVA_HOME=${home}/${packageDir} >> ~/.bashrc
echo 'export PATH=$PATH:$JAVA_HOME/bin' >> ~/.bashrc
source ~/.bashrc
