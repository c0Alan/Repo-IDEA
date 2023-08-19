home=/opt/dev/zookeeper
package=apache-zookeeper-3.5.5-bin.tar.gz
packageDir=apache-zookeeper-3.5.5-bin
downloadUrl=https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.5.5/apache-zookeeper-3.5.5-bin.tar.gz

tickTime=2000
initLimit=10
syncLimit=5
dataDir=${home}/data
dataLogDir=${home}/logs
clientPort=2181

# 需要修改
servers='server.1=192.168.170.130:2888:3888 server.1=192.168.170.129:2888:3888'
# servers='server.1=mini1:2888:3888 server.2=mini2:2888:3888 server.3=mini3:2888:3888'
myid=1