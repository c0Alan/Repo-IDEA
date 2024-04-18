#!/bin/bash

source ./publicVar.sh

cd ${home}
# wget ${downloadUrl}
tar -zxvf ${package}

chown -R hadoop:hadoop ${home}

sed -i '/HADOOP_HOME/d' /etc/profile
echo '# 配置 HADOOP_HOME 环境变量' >> /etc/profile
echo export HADOOP_HOME=${home}/${packageDir} >> /etc/profile
echo 'export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin' >> /etc/profile
source /etc/profile

su hadoop
sed -i '/HADOOP_HOME/d' ~/.bashrc
echo '# 配置 HADOOP_HOME 环境变量' >> ~/.bashrc
echo export HADOOP_HOME=${home}/${packageDir} >> ~/.bashrc
echo 'export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin' >> ~/.bashrc
source ~/.bashrc

