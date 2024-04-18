#!/bin/bash

source ./publicVar.sh

# 删除 JAVA 环境变量
sed -i '/JAVA_HOME/d' /etc/profile
echo '# 配置 JAVA_HOME 环境变量' >> /etc/profile
echo export JAVA_HOME=${home}/${packageDir} >> /etc/profile
sed -i '/JRE_HOME/d' /etc/profile
echo '# 配置 JRE_HOME 环境变量' >> /etc/profile
echo export JRE_HOME=${home}/${packageDir}/jre >> /etc/profile
echo 'export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib' >> /etc/profile
echo 'export PATH=$PATH:$JAVA_HOME/bin' >> /etc/profile
# 使配置生效
source /etc/profile

sed -i '/JAVA_HOME/d' ~/.bashrc
echo '# 配置 JAVA_HOME 环境变量' >> ~/.bashrc
echo export JAVA_HOME=${home}/${packageDir} >> ~/.bashrc
sed -i '/JRE_HOME/d' ~/.bashrc
echo '# 配置 JRE_HOME 环境变量' >> ~/.bashrc
echo export JRE_HOME=${home}/${packageDir}/jre >> ~/.bashrc
echo 'export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib' >> ~/.bashrc
echo 'export PATH=$PATH:$JAVA_HOME/bin' >> ~/.bashrc
source ~/.bashrc
