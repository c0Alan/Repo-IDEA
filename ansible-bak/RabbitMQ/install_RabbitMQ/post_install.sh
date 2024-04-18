cd /opt/dev/rabbitmq/rabbitmq_server-3.6.15/sbin

# 启动
./rabbitmq-server -detached

# 配置rabbitmq网页管理插件
# rabbitmq-plugins enable rabbitmq_management

# 开启rabbitmq远程访问
# 添加用户
./rabbitmqctl add_user liuxl 123
# 添加权限
./rabbitmqctl set_permissions -p "/" liuxl ".*" ".*" ".*"
# 修改用户角色
./rabbitmqctl set_user_tags liuxl administrator