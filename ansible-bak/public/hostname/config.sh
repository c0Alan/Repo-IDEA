#!/bin/bash
# 修改主机名
source ./publicVar.sh

hostnamectl set-hostname ${homename}

for oldHost in ${oldHosts[*]}; do
sed -i "/^${oldHost}/d" /etc/hosts
done

for host in ${hosts[*]}; do
echo ${host} >> /etc/hosts
done
