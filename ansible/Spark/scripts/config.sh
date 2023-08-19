#!/bin/bash

source ./publicVar.sh

mkdir -p /tmp/spark-events

sed -i '/SPARK_HOME/d' ~/.bashrc
echo '# 配置 SPARK_HOME 环境变量' >> ~/.bashrc
echo export SPARK_HOME=${home}/${packageDir} >> ~/.bashrc
echo 'export PATH=$PATH:$SPARK_HOME/bin:$SPARK_HOME/sbin' >> ~/.bashrc
source ~/.bashrc

cd ${configDir}

if [ -e spark-env.sh ];then
	rm -f spark-env.sh
fi
cp spark-env.sh.template spark-env.sh

echo "export SCALA_HOME=${SCALA_HOME}" >> spark-env.sh
echo "export JAVA_HOME=${JAVA_HOME}" >> spark-env.sh
echo "export HADOOP_HOME=${HADOOP_HOME}" >> spark-env.sh
echo "export HADOOP_CONF_DIR=${HADOOP_HOME}/etc/hadoop" >> spark-env.sh
echo "SPARK_MASTER_IP=${sparkMasterIp}" >> spark-env.sh
echo "SPARK_LOCAL_DIRS=${home}/${packageDir}" >> spark-env.sh
echo "SPARK_DRIVER_MEMORY=${sparkDriverMemory}" >> spark-env.sh

if [ -e slaves ];then
	rm -f slaves
fi
for slave in $slaves;  
do  
echo $slave >> ${configDir}/slaves
done
