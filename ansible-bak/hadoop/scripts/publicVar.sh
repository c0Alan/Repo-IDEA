home=/opt/dev/hadoop
package=hadoop-2.7.7.tar.gz
packageDir=hadoop-2.7.7
configDir=${home}/${packageDir}/etc/hadoop
downloadUrl=http://mirrors.tuna.tsinghua.edu.cn/apache/hadoop/common/hadoop-2.7.7/hadoop-2.7.7.tar.gz

# 配置文件列表
configFiles='core-site.xml hdfs-site.xml mapred-site.xml yarn-site.xml'

# 需要修改
master='host129'
slaves='host131 host133'