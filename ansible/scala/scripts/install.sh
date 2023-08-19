#!/bin/bash

source ./publicVar.sh

mkdir -p ${home}
tar -zxvf ../${package} -C ${home}
