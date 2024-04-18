#!/bin/bash

source ./publicVar.sh

sed -i '/HADOOP_HOME/d' ~/.bashrc
echo '# 配置 HADOOP_HOME 环境变量' >> ~/.bashrc
echo export HADOOP_HOME=${home}/${packageDir} >> ~/.bashrc
echo 'export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin' >> ~/.bashrc
source ~/.bashrc

chown -R hadoop:hadoop ${home}
if [ -e ${configDir}/slaves ];then
	rm -f slaves
fi
for slave in $slaves;  
do  
echo $slave >> ${configDir}/slaves
done

sed -i "/^export JAVA_HOME=/d" ${configDir}/hadoop-env.sh
sed -i "1i export JAVA_HOME=${JAVA_HOME}" ${configDir}/hadoop-env.sh

for configFile in ${configFiles};do
	if [ -e ${configDir}/${configFile} ];then
	rm -f ${configDir}/${configFile}
	fi
	
	cat ${configFile} | while read line
	do
		if [[ $line == *\"* ]]
		then
			echo $line >> ${configDir}/${configFile}
		else
			eval echo \"$line\" >> ${configDir}/${configFile}
		fi
	done
done

