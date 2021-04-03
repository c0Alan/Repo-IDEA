#!/bin/bash

# --spring.profiles.active=daily
# --spring.config.location=classpath:/application.yml
# -Xmn250m 年轻代
# -Xmx3550m JVM最大可用内存
# -Xms3550m JVM初始内存

source ./publicVar.sh
rm -f nohup.out

export CATALINA_OPTS='-server -Xms250m -Xmx250m -Xss256k -XX:+HeapDumpOnOutOfMemoryError'
nohup java -jar ${appName} --spring.config.location=classpath:/application.yml --spring.profiles.active=${activeProfile} --server.port=${port} -verbose:class &


