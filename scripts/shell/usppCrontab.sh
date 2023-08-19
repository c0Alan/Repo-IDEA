#!/bin/sh

################################
# 创建定时任务
################################

if [ `grep -c "usppCrontab" /var/spool/cron/root` == '0' ];then
	echo "30 23 * * * /bin/sh /opt/uspp/usppCrontab.sh" >>/var/spool/cron/root
	systemctl restart crond
fi

date >> /opt/uspp/usppCrontab.log

echo `date` > /opt/uspp/tomcat-7.0.40/logs/catalina.out