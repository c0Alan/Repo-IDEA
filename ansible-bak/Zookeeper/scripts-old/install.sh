systemctl stop firewalld
systemctl disable firewalld
mkdir -p /opt/dev/zookeeper
mkdir -p /opt/dev/zookeeper/data
wget -P /opt/dev/zookeeper https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.4.14/zookeeper-3.4.14.tar.gz
tar -zxvf /opt/dev/zookeeper/zookeeper-3.4.14.tar.gz -C /opt/dev/zookeeper
cp zoo.cfg /opt/dev/zookeeper/zookeeper-3.4.14/conf/
if [ $? -eq 0 ]; then
	echo export ZOOKEEPER_HOME=/opt/dev/zookeeper/bin/zookeeper-3.4.14 >> /etc/profile
	echo export PATH=$ZOOKEEPER_HOME/bin:$PATH >> /etc/profile
	echo export PATH >> /etc/profile
	source /etc/profile
	echo $1 > /opt/dev/zookeeper/data/myid
fi

