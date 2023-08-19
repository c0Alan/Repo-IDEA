#!/bin/bash

source ./publicVar.sh

# 切换到 es用户
# su es

cd ${home}/${packageDir}
# rm -f nohup.out
# nohup ./bin/elasticsearch &
./bin/elasticsearch -p elasticsearch-pid -d
