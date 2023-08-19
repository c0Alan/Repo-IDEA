home=/opt/dev/kafka
package=kafka_2.12-2.3.0.tgz
packageDir=kafka_2.12-2.3.0
downloadUrl=https://mirrors.tuna.tsinghua.edu.cn/apache/kafka/2.3.0/kafka_2.12-2.3.0.tgz

# 指定服务的端口
listeners='PLAINTEXT://:9092'
# 日志目录
logDirs=${home}/kafka-logs

## 需要修改
# 唯一标识
brokerId=0
# 如果要提供外网访问 必须配置此项
advertisedListeners='PLAINTEXT://192.168.31.222:9092'
zookeeperConnect='hadoop05:2181,hadoop06:2181,hadoop07:2181'