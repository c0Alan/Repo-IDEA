#!/bin/bash
# 修改时区为中国时区

/usr/bin/expect << EOF
spawn tzselect
expect {
    "#?" { send "5\n" }
}

expect {
    "#?" { send "9\n" }
}

expect {
    "#?" { send "1\n" }
}

expect {
    "#?" { send "1\n" }
}
interact
expect eof

EOF

rm -rf /etc/localtime
ln -s /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

# 查看时钟配置
# cat /etc/sysconfig/clock

echo "ZONE=\"Asia/Shanghai\"" > /etc/sysconfig/clock

# 同步网络时间
ntpdate $1
# 将系统时间写入到系统硬件当中
hwclock -w


