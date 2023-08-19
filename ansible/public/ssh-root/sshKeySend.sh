#!/bin/bash

source ./publicVar.sh

# 发送秘钥
for server in ${recieveServers};
do
# 拷贝秘钥
/usr/bin/expect << EOF
spawn ssh-copy-id -i /root/.ssh/id_rsa.pub root@$server
expect {
    "yes/no" { send "yes\n";exp_continue }
    "password" { send "${password}\n" }
}
interact
expect eof

EOF

done

exit 0