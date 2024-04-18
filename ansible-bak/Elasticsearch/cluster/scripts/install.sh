#!/bin/bash

source ./publicVar.sh

mkdir -p ${home}/data
mkdir -p ${home}/logs
cd ${home}
# wget ${downloadUrl}
tar -zxvf ${package}

## elasticsearch 不允许使用root用户启动, 创建一个 es 用户
# 以root用户来创建新的用户 ， groupadd 添加一个用户组
groupadd es
# 添加一个用户，-g是在用户组下 -p是密码
useradd es -g es -p es
# 给用户es授权
chown -R es:es ${home}

