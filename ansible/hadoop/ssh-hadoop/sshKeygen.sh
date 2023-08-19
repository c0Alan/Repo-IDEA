#!/bin/bash

mkdir -p ~/.ssh
# 生成秘钥
if [ ! -e '~/.ssh/id_rsa.pub' ];then
/usr/bin/expect << EOF
spawn ssh-keygen -t rsa -P "" -f /home/hadoop/.ssh/id_rsa
expect {
	"Overwrite" { send "n\n" }
}
interact
expect eof
EOF
fi