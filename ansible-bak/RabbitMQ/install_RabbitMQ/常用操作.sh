3、rabbitmq的基本操作：
　　启动：rabbitmq-server -detached
　　关闭：rabbitmqctl stop
　　查看状态：rabbitmqctl status
4、配置rabbitmq网页管理插件
　　启用插件：root@iZwz9eailk2tci1wywk9p2Z local]# 
	./rabbitmq-plugins enable rabbitmq_management
　   访问管理页面：http://192.168.80.130:15672  端口默认为15672
　　　　
　　默认来宾用户: guest, 来宾用户密码: guest
5、开启rabbitmq远程访问
　　添加用户:rabbitmqctl add_user XRom XRom123　　//XRom是用户名， XRom123是用户密码
　　添加权限:rabbitmqctl set_permissions -p "/" XRom ".*" ".*" ".*"
　　修改用户角色:rabbitmqctl set_user_tags XRom administrator
　　然后就可以远程访问了，然后可直接配置用户权限等信息
6、rabbitmq常用命令
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
2.3 RabbitMQ添加用户和Virtual Host
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
3.RabbitMQ的5种模式与实例
3.1 简单模式Hello World
功能：一个生产者P发送消息到队列Q,一个消费者C接收
生产者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，使用通道channel向队列中发送消息，关闭通道和连接。
 
消费者实现思路
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue, 创建消费者并监听队列，从队列中读取消息。
3.2 工作队列模式Work Queue
功能：一个生产者，多个消费者，每个消费者获取到的消息唯一，多个消费者只有一个队列
任务队列：避免立即做一个资源密集型任务，必须等待它完成，而是把这个任务安排到稍后再做。我们将任务封装为消息并将其发送给队列。后台运行的工作进程将弹出任务并最终执行作业。当有多个worker同时运行时，任务将在它们之间共享。
生产者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，使用通道channel向队列中发送消息，2条消息之间间隔一定时间，关闭通道和连接。
消费者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，创建消费者C1并监听队列，获取消息并暂停10ms，另外一个消费者C2暂停1000ms，由于消费者C1消费速度快，所以C1可以执行更多的任务。
3.3 发布/订阅模式Publish/Subscribe
功能：一个生产者发送的消息会被多个消费者获取。一个生产者、一个交换机、多个队列、多个消费者
生产者：可以将消息发送到队列或者是交换机。
消费者：只能从队列中获取消息。
如果消息发送到没有队列绑定的交换机上，那么消息将丢失。
交换机不能存储消息，消息存储在队列中
生产者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，使用通道channel创建交换机并指定交换机类型为fanout，使用通道向交换机发送消息，关闭通道和连接。
消费者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，绑定队列到交换机，设置Qos=1，创建消费者并监听队列，使用手动方式返回完成。可以有多个队列绑定到交换机，多个消费者进行监听。
3.4 路由模式Routing
说明：生产者发送消息到交换机并且要指定路由key，消费者将队列绑定到交换机时需要指定路由key
生产者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，使用通道channel创建交换机并指定交换机类型为direct，使用通道向交换机发送消息并指定key=b，关闭通道和连接。
消费者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，绑定队列到交换机，设置Qos=1，创建消费者并监听队列，使用手动方式返回完成。可以有多个队列绑定到交换机,但只要绑定key=b的队列key接收到消息，多个消费者进行监听。
3.5 通配符模式Topics  
说明：生产者P发送消息到交换机X，type=topic，交换机根据绑定队列的routing key的值进行通配符匹配；符号#：匹配一个或者多个词lazy.# 可以匹配lazy.irs或者lazy.irs.cor
符号*：只能匹配一个词lazy.* 可以匹配lazy.irs或者lazy.cor
生产者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，使用通道channel创建交换机并指定交换机类型为topic，使用通道向交换机发送消息并指定key=key.1，关闭通道和连接。
 
消费者实现思路：
创建连接工厂ConnectionFactory，设置服务地址127.0.0.1，端口号5672，设置用户名、密码、virtual host，从连接工厂中获取连接connection，使用连接创建通道channel，使用通道channel创建队列queue，绑定队列到交换机，设置Qos=1，创建消费者并监听队列，使用手动方式返回完成。可以有多个队列绑定到交换机,凡是绑定规则符合通配符规则的队列均可以接收到消息，比如key.*,key.#，多个消费者进行监听。
4.spring集成rabbitmq配置
Spring提供了AMQP的一个实现，并且spring-rabbit是RabbitMQ的一个实现，下面给出订阅者模式的事例配置如下：
5.总结
RabbitMQ提供了6种模式，分别是HelloWorld，Work Queue，Publish/Subscribe，Routing，Topics，RPC Request/reply，本文详细讲述了前5种，并给出代码实现和思路。其中Publish/Subscribe，Routing，Topics三种模式可以统一归为Exchange模式，只是创建时交换机的类型不一样，分别是fanout、direct、topic。Spring提供了rabbitmq的一个实现，所以集成起来很方便，文章第4章给出了订阅者模式的一种spring配置。