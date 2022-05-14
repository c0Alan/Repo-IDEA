#!/bin/sh

# 离线安装配置java
# 参考: https://www.cnblogs.com/tony-hyn/p/15777762.html
script_dir="/opt/script/java"
package_dir=${script_dir}/package
mkdir -p ${package_dir}
package_name="jdk-8u221-linux-x64.tar.gz"
install_dir="/usr/local/java"
mkdir -p ${install_dir}

cd ${package_dir}
tar -zxvf ${package_name} -C ${install_dir}

echo 'export JAVA_HOME=/usr/local/java/jdk1.8.0_221' >> /etc/profile
echo 'export JRE_HOME=${JAVA_HOME}/jre' >> /etc/profile
echo 'export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib' >> /etc/profile
echo 'export PATH=${JAVA_HOME}/bin:$PATH' >> /etc/profile

source /etc/profile

# 添加软链接
ln -s /usr/local/java/jdk1.8.0_221/bin/java /usr/bin/java
ln -s /usr/local/java/jdk1.8.0_221/bin/javac /usr/bin/javac

java -version
