rabbitmq的基本操作：
　　　　启动：rabbitmq-server -detached
　　　　关闭：rabbitmqctl stop
　　　　查看状态：rabbitmqctl status
配置rabbitmq网页管理插件
　　　　启用插件：root@iZwz9eailk2tci1wywk9p2Z local]# rabbitmq-plugins enable rabbitmq_management
 　　　   访问管理页面：http://192.168.?.?:15672  端口默认为15672
　　　　　　
　　　　默认来宾用户：guest， 来宾用户密码：guest
开启rabbitmq远程访问
　　　　添加用户:rabbitmqctl add_user XRom XRom123　　//XRom是用户名， XRom123是用户密码
　　　　添加权限:rabbitmqctl set_permissions -p "/" XRom ".*" ".*" ".*"
　　　　修改用户角色:rabbitmqctl set_user_tags XRom administrator
　　　　然后就可以远程访问了，然后可直接配置用户权限等信息
rabbitmq常用命令
　　　　add_user        <UserName> <Password>
　　　　delete_user    <UserName>
　　　　change_password <UserName> <NewPassword>
　　　　list_users
　　　　add_vhost    <VHostPath>
　　　　delete_vhost <VHostPath>
　　　　list_vhostsset_permissions  [-p <VHostPath>] <UserName> <Regexp> <Regexp> <Regexp>
　　　　clear_permissions [-p <VHostPath>] <UserName>
　　　　list_permissions  [-p <VHostPath>]
　　　　list_user_permissions <UserName>
　　　　list_queues    [-p <VHostPath>] [<QueueInfoItem> ...]
　　　　list_exchanges [-p <VHostPath>] [<ExchangeInfoItem> ...]
　　　　list_bindings  [-p <VHostPath>]
　　　　list_connections [<ConnectionInfoItem> ...]
RabbitMQ添加用户和Virtual Host
Admin-Users-Add a user
Tags:用户角色说明
 超级管理员(administrator)
可登陆管理控制台，可查看所有的信息，并且可以对用户，策略(policy)进行操作。
监控者(monitoring)
可登陆管理控制台，同时可以查看rabbitmq节点的相关信息(进程数，内存使用情况，磁盘使用情况等)
策略制定者(policymaker)
可登陆管理控制台, 同时可以对policy进行管理,但无法查看节点的相关信息。
普通管理者(management)
仅可登陆管理控制台，无法看到节点信息，也无法对策略进行管理。
其他none
无法登陆管理控制台，通常就是普通的生产者和消费者。
Admin-Virtual Host-Add virtual host
添加virtual host和用户后，需要为用户指定virtual host，之后用该用户可以登录