#!/bin/bash

source ./publicVar.sh

mkdir -p ${home}
cp ../${package} ${home}
cd ${home}
tar -zxvf ${package}
