#!/bin/bash

source ./publicVar.sh

# 切换到 es用户
# su es

cd ${home}/${packageDir}
# rm -f nohup.out
# nohup ./bin/elasticsearch &
nohup ./bin/kibana &
