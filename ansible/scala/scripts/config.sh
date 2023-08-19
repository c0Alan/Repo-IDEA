#!/bin/bash

source ./publicVar.sh

# 删除 JAVA 环境变量
sed -i '/SCALA_HOME/d' /etc/profile
echo '# 配置 SCALA_HOME 环境变量' >> /etc/profile
echo export SCALA_HOME=${home}/${packageDir} >> /etc/profile
echo 'export PATH=$PATH:$SCALA_HOME/bin' >> /etc/profile
# 使配置生效
source /etc/profile

sed -i '/SCALA_HOME/d' ~/.bashrc
echo '# 配置 SCALA_HOME 环境变量' >> ~/.bashrc
echo export SCALA_HOME=${home}/${packageDir} >> ~/.bashrc
echo 'export PATH=$PATH:$SCALA_HOME/bin' >> ~/.bashrc
source ~/.bashrc
