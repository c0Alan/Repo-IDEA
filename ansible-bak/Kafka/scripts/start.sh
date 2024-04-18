#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}
# rm -f nohup.out
nohup bin/kafka-server-start.sh config/server.properties &
