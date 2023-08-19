#!/bin/bash

source ./publicVar.sh
kill 9 `ps -aux | grep kibana | grep -v grep | awk '{print $2}'`