#!/bin/bash

source ./publicVar.sh

cd ${home}
wget https://artifacts.elastic.co/downloads/kibana/kibana-6.0.0-linux-x86_64.tar.gz
tar -xzf kibana-6.0.0-linux-x86_64.tar.gz
