#!/bin/bash

MODEL_VARS_VALUE="--spring.config.location=./application.yml --logging.config=./logback-spring.xml"
JVM_VARS_VALUE="-server -Xms250m -Xmx250m -Xss256k -XX:+HeapDumpOnOutOfMemoryError"
# JVM_VARS_VALUE="-server -XX:MetaspaceSize=1g -XX:MaxMetaspaceSize=2g -Xms4g -Xmx8g"
