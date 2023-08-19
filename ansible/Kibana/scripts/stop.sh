#!/bin/bash

source ./publicVar.sh

cd ${home}/${packageDir}

kill 9 `cat elasticsearch-pid`

rm -f elasticsearch-pid
