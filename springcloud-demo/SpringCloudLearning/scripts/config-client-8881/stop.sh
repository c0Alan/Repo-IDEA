#!/bin/bash

# --spring.profiles.active=daily

source ./publicVar.sh
kill 9 `ps -aux | grep ${appName} | grep port=${port} | grep -v grep | awk '{print $2}'`


