#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}

sbin/start-all.sh
sbin/start-history-server.sh
