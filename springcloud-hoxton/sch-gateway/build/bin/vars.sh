#!/bin/bash

# PROFILES参数
SPRING_PROFILES_ACTIVE="prod,config"

# 如果使用nacos配置中心，开启以下配置，反之注释掉以下配置
MODEL_VARS_VALUE="--spring.config.location=../conf/ --spring.profiles.active=${SPRING_PROFILES_ACTIVE} --logging.config=../conf/logback-spring.xml"

JVM_VARS_VALUE="-server -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m -Xms128m -Xmx128m"

# 开启jmx
# JMX_VARS_VALUE="-Djava.rmi.server.hostname=172.25.21.29  -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9192  -Dcom.sun.management.jmxremote.rmi.port=9193 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
