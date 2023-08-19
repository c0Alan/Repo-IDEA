#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}

bin/hdfs namenode -format
