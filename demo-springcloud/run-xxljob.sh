#!/bin/bash

# PROFILES参数
SPRING_PROFILES_ACTIVE="prod,config"

# 如果使用nacos配置中心，开启以下配置，反之注释掉以下配置
MODEL_VARS_VALUE="--spring.config.location=../conf/ --spring.profiles.active=${SPRING_PROFILES_ACTIVE} --logging.config=../conf/logback-spring.xml"



JVM_VARS="-server -XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=1g -Xms512m -Xmx1g"

GREP_KEY="Diname=xxl-job-admin-2.3.1-SNAPSHOT.jar"

MODEL_LOG="../logs/error.log"

MODEL_JAR="/opt/xxl-job/bin/xxl-job-admin-2.3.1-SNAPSHOT.jar"

MODEL_VARS="--spring.config.location=../conf/ --logging.config=../conf/logback.xml"

nohup $JAVA_HOME/bin/java -${GREP_KEY} -jar ${JVM_VARS} ${MODEL_JAR} ${MODEL_VARS} 1>&- 2>>${MODEL_LOG} &

