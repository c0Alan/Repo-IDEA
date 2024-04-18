#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}

sbin/stop-yarn.sh
sbin/stop-dfs.sh
sbin/mr-jobhistory-daemon.sh stop historyserver
