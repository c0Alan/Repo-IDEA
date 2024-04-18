#!/bin/bash

source ./publicVar.sh

#创建用户
useradd -m ${userName} -g ${groudName} -s /bin/bash 

expect << EOF  
spawn passwd ${userName}  
expect "New password:"  
send "${password}\r"  
expect "Retype new password:"  
send "${password}\r"  
expect eof;  
EOF

chmod -v u+w /etc/sudoers
sed -i "/^${userName}/d" /etc/sudoers
echo "${userName} ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
chmod -v u-w /etc/sudoers