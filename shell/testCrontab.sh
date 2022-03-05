#!/bin/sh

################################
# 创建定时任务
################################

if [ `grep -c "testCrontab" /var/spool/cron/root` == '0' ];then
	echo "*/1 * * * * /bin/sh /opt/tmp/testCrontab.sh" >>/var/spool/cron/root
	systemctl restart crond
fi

date >> /opt/tmp/testCrontab.log