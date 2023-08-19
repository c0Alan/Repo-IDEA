#!/bin/bash
ansible-playbook mysql_install.yml -i db.ini --skip-tags=start,stop -vv
#echo "安装mysql的机器ip: $1"
#echo "安装mysql的目录: $2"
#ssh $1 "/bin/bash $2/mysql/create_database.sh"
