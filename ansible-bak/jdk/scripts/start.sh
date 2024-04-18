#!/bin/bash

source ./publicVar.sh

cd ${home}/${package}
rm -f nohup.out
nohup bin/kibana &

# aaa
