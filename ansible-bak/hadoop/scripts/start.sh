#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}

sbin/start-dfs.sh
sbin/start-yarn.sh
sbin/mr-jobhistory-daemon.sh start historyserver
