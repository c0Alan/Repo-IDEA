#!/bin/bash
# 免密设置

# 传参
echo $1

# 生成秘钥
/usr/bin/expect << EOF
spawn ssh-keygen -t rsa -P "" -f /root/.ssh/id_rsa
expect {
	"Overwrite" { send "n\n" }
}
interact
expect eof
EOF

# 拷贝秘钥
/usr/bin/expect << EOF
spawn ssh-copy-id -i /root/.ssh/id_rsa.pub root@$1
expect {
    "yes/no" { send "yes\n";exp_continue }
    "password" { send "123\n" }
}
interact
expect eof

EOF

exit 0