#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}

sbin/stop-all.sh
sbin/stop-history-server.sh
