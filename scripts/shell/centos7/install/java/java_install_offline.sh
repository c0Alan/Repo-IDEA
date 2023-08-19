#!/bin/sh

# 离线安装配置java
# 参考: https://blog.csdn.net/Frank_ZZ_/article/details/100313738
script_dir="/opt/script/java"
package_dir=${script_dir}/package
mkdir -p ${package_dir}
package_name="jdk-8u381-linux-x64.tar.gz"
install_dir="/usr/local/java"
mkdir -p ${install_dir}

JAVA_HOME="/usr/local/java/jdk1.8.0_381"

cd ${package_dir}
tar -zxvf ${package_name} -C ${install_dir}

# 删除所有匹配到字符串的行
sed -i '/JAVA_HOME/d' /etc/profile

echo 'export JAVA_HOME='${JAVA_HOME} >> /etc/profile
echo 'export JRE_HOME=${JAVA_HOME}/jre' >> /etc/profile
echo 'export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib' >> /etc/profile
echo 'export PATH=${JAVA_HOME}/bin:$PATH' >> /etc/profile

source /etc/profile

# 添加软链接
rm -f /usr/bin/java
rm -f /usr/bin/javac
rm -f /usr/bin/javaws
ln -s ${JAVA_HOME}/bin/java /usr/bin/java
ln -s ${JAVA_HOME}/bin/javac /usr/bin/javac
ln -s ${JAVA_HOME}/bin/javaws /usr/bin/javaws

java -version
