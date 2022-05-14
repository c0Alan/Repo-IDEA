#!/bin/sh

##### 修改yum源

# 备份原有yum源
mv /etc/yum.repos.d /etc/yum.repos.d.bak

# 创建yum源目录
mkdir /etc/yum.repos.d

# 下载阿里云yum源配置
wget -O /etc/yum.repos.d/CentOS-Base.repo https://repo.huaweicloud.com/repository/conf/CentOS-7-reg.repo

# 重建yum缓存
yum clean all
yum makecache

