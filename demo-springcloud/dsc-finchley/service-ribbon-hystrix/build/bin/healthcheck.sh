#!/bin/sh

name="service-ribbon-hystrix"
count=`ps -ef|grep -w $name|grep -v grep|wc -l`
if [ $count -eq 0 ];then
    echo "health check failed"
    exit 1
fi
