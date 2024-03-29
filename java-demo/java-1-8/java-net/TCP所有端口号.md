## 著名端口

| 端口号码 / 层 | 名称           | 注释                                                         |
| ------------- | -------------- | ------------------------------------------------------------ |
| 1             | tcpmux         | TCP 端口服务多路复用                                         |
| 5             | rje            | 远程作业入口                                                 |
| 7             | echo           | Echo 服务                                                    |
| 9             | discard        | 用于连接测试的空服务                                         |
| 11            | systat         | 用于列举连接了的端口的系统状态                               |
| 13            | daytime        | 给请求主机发送日期和时间                                     |
| 17            | qotd           | 给连接了的主机发送每日格言                                   |
| 18            | msp            | 消息发送协议                                                 |
| 19            | chargen        | 字符生成服务；发送无止境的字符流                             |
| 20            | ftp-data       | FTP 数据端口                                                 |
| 21            | ftp            | 文件传输协议（FTP）端口；有时被文件服务协议（FSP）使用       |
| 22            | ssh            | 安全 Shell（SSH）服务                                        |
| 23            | telnet         | Telnet 服务                                                  |
| 25            | smtp           | 简单邮件传输协议（SMTP）                                     |
| 37            | time           | 时间协议                                                     |
| 39            | rlp            | 资源定位协议                                                 |
| 42            | nameserver     | 互联网名称服务                                               |
| 43            | nicname        | WHOIS 目录服务                                               |
| 49            | tacacs         | 用于基于 TCP/IP 验证和访问的终端访问控制器访问控制系统       |
| 50            | re-mail-ck     | 远程邮件检查协议                                             |
| 53            | domain         | 域名服务（如 BIND）                                          |
| 63            | whois++        | WHOIS++，被扩展了的 WHOIS 服务                               |
| 67            | bootps         | 引导协议（BOOTP）服务；还被动态主机配置协议（DHCP）服务使用  |
| 68            | bootpc         | Bootstrap（BOOTP）客户；还被动态主机配置协议（DHCP）客户使用 |
| 69            | tftp           | 小文件传输协议（TFTP）                                       |
| 70            | gopher         | Gopher 互联网文档搜寻和检索                                  |
| 71            | netrjs-1       | 远程作业服务                                                 |
| 72            | netrjs-2       | 远程作业服务                                                 |
| 73            | netrjs-3       | 远程作业服务                                                 |
| 73            | netrjs-4       | 远程作业服务                                                 |
| 79            | finger         | 用于用户联系信息的 Finger 服务                               |
| 80            | http           | 用于万维网（WWW）服务的超文本传输协议（HTTP）                |
| 88            | kerberos       | Kerberos 网络验证系统                                        |
| 95            | supdup         | Telnet 协议扩展                                              |
| 101           | hostname       | SRI-NIC 机器上的主机名服务                                   |
| 102           | iso-tsap       | ISO 开发环境（ISODE）网络应用                                |
| 105           | csnet-ns       | 邮箱名称服务器；也被 CSO 名称服务器使用                      |
| 107           | rtelnet        | 远程 Telnet                                                  |
| 109           | pop2           | 邮局协议版本2                                                |
| 110           | pop3           | 邮局协议版本3                                                |
| 111           | sunrpc         | 用于远程命令执行的远程过程调用（RPC）协议，被网络文件系统（NFS）使用 |
| 113           | auth           | 验证和身份识别协议                                           |
| 115           | sftp           | 安全文件传输协议（SFTP）服务                                 |
| 117           | uucp-path      | Unix 到 Unix 复制协议（UUCP）路径服务                        |
| 119           | nntp           | 用于 USENET 讨论系统的网络新闻传输协议（NNTP）               |
| 123           | ntp            | 网络时间协议（NTP）                                          |
| 137           | netbios-ns     | 在红帽企业 Linux 中被 Samba 使用的 NETBIOS 名称服务          |
| 138           | netbios-dgm    | 在红帽企业 Linux 中被 Samba 使用的 NETBIOS 数据报服务        |
| 139           | netbios-ssn    | 在红帽企业 Linux 中被 Samba 使用的NET BIOS 会话服务          |
| 143           | imap           | 互联网消息存取协议（IMAP）                                   |
| 161           | snmp           | 简单网络管理协议（SNMP）                                     |
| 162           | snmptrap       | SNMP 的陷阱                                                  |
| 163           | cmip-man       | 通用管理信息协议（CMIP）                                     |
| 164           | cmip-agent     | 通用管理信息协议（CMIP）                                     |
| 174           | mailq          | MAILQ                                                        |
| 177           | xdmcp          | X 显示管理器控制协议                                         |
| 178           | nextstep       | NeXTStep 窗口服务器                                          |
| 179           | bgp            | 边界网络协议                                                 |
| 191           | prospero       | Cliffod Neuman 的 Prospero 服务                              |
| 194           | irc            | 互联网中继聊天（IRC）                                        |
| 199           | smux           | SNMP UNIX 多路复用                                           |
| 201           | at-rtmp        | AppleTalk 选路                                               |
| 202           | at-nbp         | AppleTalk 名称绑定                                           |
| 204           | at-echo        | AppleTalk echo 服务                                          |
| 206           | at-zis         | AppleTalk 区块信息                                           |
| 209           | qmtp           | 快速邮件传输协议（QMTP）                                     |
| 210           | z39.50         | NISO Z39.50 数据库                                           |
| 213           | ipx            | 互联网络分组交换协议（IPX），被 Novell Netware 环境常用的数据报协议 |
| 220           | imap3          | 互联网消息存取协议版本3                                      |
| 245           | link           | LINK                                                         |
| 347           | fatserv        | Fatmen 服务器                                                |
| 363           | rsvp_tunnel    | RSVP 隧道                                                    |
| 369           | rpc2portmap    | Coda 文件系统端口映射器                                      |
| 370           | codaauth2      | Coda 文件系统验证服务                                        |
| 372           | ulistproc      | UNIX Listserv                                                |
| 389           | ldap           | 轻型目录存取协议（LDAP）                                     |
| 427           | svrloc         | 服务位置协议（SLP）                                          |
| 434           | mobileip-agent | 可移互联网协议（IP）代理                                     |
| 435           | mobilip-mn     | 可移互联网协议（IP）管理器                                   |
| 443           | https          | 安全超文本传输协议（HTTP）                                   |
| 444           | snpp           | 小型网络分页协议                                             |
| 445           | microsoft-ds   | 通过 TCP/IP 的服务器消息块（SMB）                            |
| 464           | kpasswd        | Kerberos 口令和钥匙改换服务                                  |
| 468           | photuris       | Photuris 会话钥匙管理协议                                    |
| 487           | saft           | 简单不对称文件传输（SAFT）协议                               |
| 488           | gss-http       | 用于 HTTP 的通用安全服务（GSS）                              |
| 496           | pim-rp-disc    | 用于协议独立的多址传播（PIM）服务的会合点发现（RP-DISC）     |
| 500           | isakmp         | 互联网安全关联和钥匙管理协议（ISAKMP）                       |
| 535           | iiop           | 互联网内部对象请求代理协议（IIOP）                           |
| 538           | gdomap         | GNUstep 分布式对象映射器（GDOMAP）                           |
| 546           | dhcpv6-client  | 动态主机配置协议（DHCP）版本6客户                            |
| 547           | dhcpv6-server  | 动态主机配置协议（DHCP）版本6服务                            |
| 554           | rtsp           | 实时流播协议（RTSP）                                         |
| 563           | nntps          | 通过安全套接字层的网络新闻传输协议（NNTPS）                  |
| 565           | whoami         | whoami                                                       |
| 587           | submission     | 邮件消息提交代理（MSA）                                      |
| 610           | npmp-local     | 网络外设管理协议（NPMP）本地 / 分布式排队系统（DQS）         |
| 611           | npmp-gui       | 网络外设管理协议（NPMP）GUI / 分布式排队系统（DQS）          |
| 612           | hmmp-ind       | HMMP 指示 / DQS                                              |
| 631           | ipp            | 互联网打印协议（IPP）                                        |
| 636           | ldaps          | 通过安全套接字层的轻型目录访问协议（LDAPS）                  |
| 674           | acap           | 应用程序配置存取协议（ACAP）                                 |
| 694           | ha-cluster     | 用于带有高可用性的群集的心跳服务                             |
| 749           | kerberos-adm   | Kerberos 版本5（v5）的“kadmin”数据库管理                     |
| 750           | kerberos-iv    | Kerberos 版本4（v4）服务                                     |
| 765           | webster        | 网络词典                                                     |
| 767           | phonebook      | 网络电话簿                                                   |
| 873           | rsync          | rsync 文件传输服务                                           |
| 992           | telnets        | 通过安全套接字层的 Telnet（TelnetS）                         |
| 993           | imaps          | 通过安全套接字层的互联网消息存取协议（IMAPS）                |
| 994           | ircs           | 通过安全套接字层的互联网中继聊天（IRCS）                     |
| 995           | pop3s          | 通过安全套接字层的邮局协议版本3（POPS3）                     |

## UNIX 特有的端口

以下端口是 UNIX 特有的，涉及了从电子邮件到验证不等的服务。在方括号内的名称（如 [service]）是服务的守护进程名称或它的常用别名。

| 端口号码 / 层 | 名称                       | 注释                                                    |
| ------------- | -------------------------- | ------------------------------------------------------- |
| 512/tcp       | exec                       | 用于对远程执行的进程进行验证                            |
| 512/udp       | biff [comsat]              | 异步邮件客户（biff）和服务（comsat）                    |
| 513/tcp       | login                      | 远程登录（rlogin）                                      |
| 513/udp       | who [whod]                 | 登录的用户列表                                          |
| 514/tcp       | shell [cmd]                | 不必登录的远程 shell（rshell）和远程复制（rcp）         |
| 514/udp       | syslog                     | UNIX 系统日志服务                                       |
| 515           | printer [spooler]          | 打印机（lpr）假脱机                                     |
| 517/udp       | talk                       | 远程对话服务和客户                                      |
| 518/udp       | ntalk                      | 网络交谈（ntalk），远程对话服务和客户                   |
| 519           | utime [unixtime]           | UNIX 时间协议（utime）                                  |
| 520/tcp       | efs                        | 扩展文件名服务器（EFS）                                 |
| 520/udp       | router [route, routed]     | 选路信息协议（RIP）                                     |
| 521           | ripng                      | 用于互联网协议版本6（IPv6）的选路信息协议               |
| 525           | timed [timeserver]         | 时间守护进程（timed）                                   |
| 526/tcp       | tempo [newdate]            | Tempo                                                   |
| 530/tcp       | courier [rpc]              | Courier 远程过程调用（RPC）协议                         |
| 531/tcp       | conference [chat]          | 互联网中继聊天                                          |
| 532           | netnews                    | Netnews                                                 |
| 533/udp       | netwall                    | 用于紧急广播的 Netwall                                  |
| 540/tcp       | uucp [uucpd]               | Unix 到 Unix 复制服务                                   |
| 543/tcp       | klogin                     | Kerberos 版本5（v5）远程登录                            |
| 544/tcp       | kshell                     | Kerberos 版本5（v5）远程 shell                          |
| 548           | afpovertcp                 | 通过传输控制协议（TCP）的 Appletalk 文件编制协议（AFP） |
| 556           | remotefs [rfs_server, rfs] | Brunhoff 的远程文件系统（RFS）                          |

## 注册的端口

列举了由网络和软件社区向 IANA 提交的要在端口号码列表中正式注册的端口。

| 端口号码 / 层 | 名称                     | 注释                                                         |
| ------------- | ------------------------ | ------------------------------------------------------------ |
| 1080          | socks                    | SOCKS 网络应用程序代理服务                                   |
| 1236          | bvcontrol [rmtcfg]       | Garcilis Packeten 远程配置服务器                             |
| 1300          | h323hostcallsc           | H.323 电话会议主机电话安全                                   |
| 1433          | ms-sql-s                 | Microsoft SQL 服务器                                         |
| 1434          | ms-sql-m                 | Microsoft SQL 监视器                                         |
| 1494          | ica                      | Citrix ICA 客户                                              |
| 1512          | wins                     | Microsoft Windows 互联网名称服务器                           |
| 1524          | ingreslock               | Ingres 数据库管理系统（DBMS）锁定服务                        |
| 1525          | prospero-np              | 无特权的 Prospero                                            |
| 1645          | datametrics [old-radius] | Datametrics / 从前的 radius 项目                             |
| 1646          | sa-msg-port [oldradacct] | sa-msg-port / 从前的 radacct 项目                            |
| 1649          | kermit                   | Kermit 文件传输和管理服务                                    |
| 1701          | l2tp [l2f]               | 第2层隧道服务（LT2P） / 第2层转发（L2F）                     |
| 1718          | h323gatedisc             | H.323 电讯守门装置发现机制                                   |
| 1719          | h323gatestat             | H.323 电讯守门装置状态                                       |
| 1720          | h323hostcall             | H.323 电讯主持电话设置                                       |
| 1758          | tftp-mcast               | 小文件 FTP 组播                                              |
| 1759          | mtftp                    | 组播小文件 FTP（MTFTP）                                      |
| 1789          | hello                    | Hello 路由器通信端口                                         |
| 1812          | radius                   | Radius 拨号验证和记帐服务                                    |
| 1813          | radius-acct              | Radius 记帐                                                  |
| 1911          | mtp                      | Starlight 网络多媒体传输协议（MTP）                          |
| 1985          | hsrp                     | Cisco 热备用路由器协议                                       |
| 1986          | licensedaemon            | Cisco 许可管理守护进程                                       |
| 1997          | gdp-port                 | Cisco 网关发现协议（GDP）                                    |
| 2049          | nfs [nfsd]               | 网络文件系统（NFS）                                          |
| 2102          | zephyr-srv               | Zephyr 通知传输和发送服务器                                  |
| 2103          | zephyr-clt               | Zephyr serv-hm 连接                                          |
| 2104          | zephyr-hm                | Zephyr 主机管理器                                            |
| 2401          | cvspserver               | 并行版本系统（CVS）客户 / 服务器操作                         |
| 2430/tcp      | venus                    | 用于 Coda 文件系统（codacon 端口）的 Venus 缓存管理器        |
| 2430/udp      | venus                    | 用于 Coda 文件系统（callback/wbc interface 界面）的 Venus 缓存管理器 |
| 2431/tcp      | venus-se                 | Venus 传输控制协议（TCP）的副作用                            |
| 2431/udp      | venus-se                 | Venus 用户数据报协议（UDP）的副作用                          |
| 2432/udp      | codasrv                  | Coda 文件系统服务器端口                                      |
| 2433/tcp      | codasrv-se               | Coda 文件系统 TCP 副作用                                     |
| 2433/udp      | codasrv-se               | Coda 文件系统 UDP SFTP 副作用                                |
| 2600          | hpstgmgr [zebrasrv]      | HPSTGMGR；Zebra 选路                                         |
| 2601          | discp-client [zebra]     | discp 客户；Zebra 集成的 shell                               |
| 2602          | discp-server [ripd]      | discp 服务器；选路信息协议守护进程（ripd）                   |
| 2603          | servicemeter [ripngd]    | 服务计量；用于 IPv6 的 RIP 守护进程                          |
| 2604          | nsc-ccs [ospfd]          | NSC CCS；开放式短路径优先守护进程（ospfd）                   |
| 2605          | nsc-posa                 | NSC POSA；边界网络协议守护进程（bgpd）                       |
| 2606          | netmon [ospf6d]          | Dell Netmon；用于 IPv6 的 OSPF 守护进程（ospf6d）            |
| 2809          | corbaloc                 | 公共对象请求代理体系（CORBA）命名服务定位器                  |
| 3130          | icpv2                    | 互联网缓存协议版本2（v2）；被 Squid 代理缓存服务器使用       |
| 3306          | mysql                    | MySQL 数据库服务                                             |
| 3346          | trnsprntproxy            | Trnsprnt 代理                                                |
| 4011          | pxe                      | 执行前环境（PXE）服务                                        |
| 4321          | rwhois                   | 远程 Whois（rwhois）服务                                     |
| 4444          | krb524                   | Kerberos 版本5（v5）到版本4（v4）门票转换器                  |
| 5002          | rfe                      | 无射频以太网（RFE）音频广播系统                              |
| 5308          | cfengine                 | 配置引擎（Cfengine）                                         |
| 5999          | cvsup [CVSup]            | CVSup 文件传输和更新工具                                     |
| 6000          | x11 [X]                  | X 窗口系统服务                                               |
| 7000          | afs3-fileserver          | Andrew 文件系统（AFS）文件服务器                             |
| 7001          | afs3-callback            | 用于给缓存管理器回电的 AFS 端口                              |
| 7002          | afs3-prserver            | AFS 用户和组群数据库                                         |
| 7003          | afs3-vlserver            | AFS 文件卷位置数据库                                         |
| 7004          | afs3-kaserver            | AFS Kerberos 验证服务                                        |
| 7005          | afs3-volser              | AFS 文件卷管理服务器                                         |
| 7006          | afs3-errors              | AFS 错误解释服务                                             |
| 7007          | afs3-bos                 | AFS 基本监查进程                                             |
| 7008          | afs3-update              | AFS 服务器到服务器更新器                                     |
| 7009          | afs3-rmtsys              | AFS 远程缓存管理器服务                                       |
| 9876          | sd                       | 会话指引器                                                   |
| 10080         | amanda                   | 高级 Maryland 自动网络磁盘归档器（Amanda）备份服务           |
| 11371         | pgpkeyserver             | 良好隐私（PGP） / GNU 隐私卫士（GPG）公钥服务器              |
| 11720         | h323callsigalt           | H.323 调用信号交替                                           |
| 13720         | bprd                     | Veritas NetBackup 请求守护进程（bprd）                       |
| 13721         | bpdbm                    | Veritas NetBackup 数据库管理器（bpdbm）                      |
| 13722         | bpjava-msvc              | Veritas NetBackup Java / Microsoft Visual C++ (MSVC) 协议    |
| 13724         | vnetd                    | Veritas 网络工具                                             |
| 13782         | bpcd                     | Vertias NetBackup                                            |
| 13783         | vopied                   | Veritas VOPIED 协议                                          |
| 22273         | wnn6 [wnn4]              | 假名/汉字转换系统                                            |
| 26000         | quake                    | Quake（以及相关的）多人游戏服务器                            |
| 26208         | wnn6-ds                  |                                                              |
| 33434         | traceroute               | Traceroute 网络跟踪工具                                      |

注: /etc/services中的注释如下：端口1236被注册为“bvcontrol”，但是它也被 Gracilis Packeten 远程配置服务器使用。正式名称被列为主要名称，未注册的名称被列为别名。  在/etc/services中的注释：端口 2600 到 2606 被 zebra 软件包未经注册而使用。主要名称是被注册的名称，被 zebra 使用的未注册名称被列为别名。  /etc/services 文件中的注释：该端口被注册为 wnn6，但是还在 FreeWnn 软件包中使用了未注册的“wnn4”。 

## 数据报传递协议端口

显示了一个和数据报传递协议（DDP）有关的端口列表。DDP 在 AppleTalk 网络上被使用。

| 端口号码 / 层 | 名称 | 注释                |
| ------------- | ---- | ------------------- |
| 1/ddp         | rtmp | 路由表管理协议      |
| 2/ddp         | nbp  | 名称绑定协议        |
| 4/ddp         | echo | AppleTalk Echo 协议 |
| 6/ddp         | zip  | 区块信息协议        |

## Kerberos（工程 Athena/MIT）端口

和 Kerberos 网络验证协议相关的端口列表。在标记的地方，v5 代表 Kerberos 版本5协议。注意，这些端口没有在 IANA 注册。

| 端口号码 / 层 | 名称             | 注释                                 |
| ------------- | ---------------- | ------------------------------------ |
| 751           | kerberos_master  | Kerberos 验证                        |
| 752           | passwd_server    | Kerberos 口令（kpasswd）服务器       |
| 754           | krb5_prop        | Kerberos v5 从属传播                 |
| 760           | krbupdate [kreg] | Kerberos 注册                        |
| 1109          | kpop             | Kerberos 邮局协议（KPOP）            |
| 2053          | knetd            | Kerberos 多路分用器                  |
| 2105          | eklogin          | Kerberos v5 加密的远程登录（rlogin） |

## 未注册的端口

一个未注册的端口列表。这些端口可能被安装在你的红帽企业 Linux 系统上的服务或协议使用，或者它们是在红帽企业 Linux 和运行其它操作系统的机器通信所必需的端口。

| 端口号码 / 层 | 名称                       | 注释                                                         |
| ------------- | -------------------------- | ------------------------------------------------------------ |
| 15/tcp        | netstat                    | 网络状态（netstat）                                          |
| 98/tcp        | linuxconf                  | Linuxconf Linux 管理工具                                     |
| 106           | poppassd                   | 邮局协议口令改变守护进程（POPPASSD）                         |
| 465/tcp       | smtps                      | 通过安全套接字层的简单邮件传输协议（SMTPS）                  |
| 616/tcp       | gii                        | 使用网关的（选路守护进程）互动界面                           |
| 808           | omirr [omirrd]             | 联机镜像（Omirr）文件镜像服务                                |
| 871/tcp       | supfileserv                | 软件升级协议（SUP）服务器                                    |
| 901/tcp       | swat                       | Samba 万维网管理工具（SWAT）                                 |
| 953           | rndc                       | Berkeley 互联网名称域版本9（BIND 9）远程名称守护进程配置工具 |
| 1127          | sufiledbg                  | 软件升级协议（SUP）调试                                      |
| 1178/tcp      | skkserv                    | 简单假名到汉字（SKK）日文输入服务器                          |
| 1313/tcp      | xtel                       | 法国 Minitel 文本信息系统                                    |
| 1529/tcp      | support [prmsd, gnatsd]    | GNATS 错误跟踪系统                                           |
| 2003/tcp      | cfinger                    | GNU Finger 服务                                              |
| 2150          | ninstall                   | 网络安装服务                                                 |
| 2988          | afbackup                   | afbackup 客户-服务器备份系统                                 |
| 3128/tcp      | squid                      | Squid 万维网代理缓存                                         |
| 3455          | prsvp                      | RSVP 端口                                                    |
| 5432          | postgres                   | PostgreSQL 数据库                                            |
| 4557/tcp      | fax                        | FAX 传输服务（旧服务）                                       |
| 4559/tcp      | hylafax                    | HylaFAX 客户-服务器协议（新服务）                            |
| 5232          | sgi-dgl                    | SGI 分布式图形库                                             |
| 5354          | noclog                     | NOCOL 网络操作中心记录守护进程（noclogd）                    |
| 5355          | hostmon                    | NOCOL 网络操作中心主机监视                                   |
| 5680/tcp      | canna                      | Canna 日文字符输入界面                                       |
| 6010/tcp      | x11-ssh-offset             | 安全 Shell（SSH）X11 转发偏移                                |
| 6667          | ircd                       | 互联网中继聊天守护进程（ircd）                               |
| 7100/tcp      | xfs                        | X 字体服务器（XFS）                                          |
| 7666/tcp      | tircproxy                  | Tircproxy IRC 代理服务                                       |
| 8008          | http-alt                   | 超文本传输协议（HTTP）的另一选择                             |
| 8080          | webcache                   | 万维网（WWW）缓存服务                                        |
| 8081          | tproxy                     | 透明代理                                                     |
| 9100/tcp      | jetdirect [laserjet, hplj] | Hewlett-Packard (HP) JetDirect 网络打印服务                  |
| 9359          | mandelspawn [mandelbrot]   | 用于 X 窗口系统的并行 Mandelbrot 生成程序                    |
| 10081         | kamanda                    | 使用 Kerberos 的 Amanda 备份服务                             |
| 10082/tcp     | amandaidx                  | Amanda 备份服务                                              |
| 10083/tcp     | amidxtape                  | Amanda 备份服务                                              |
| 20011         | isdnlog                    | 综合业务数字网（ISDN）登录系统                               |
| 20012         | vboxd                      | ISDN 音箱守护进程（vboxd）                                   |
| 22305/tcp     | wnn4_Kr                    | kWnn 韩文输入系统                                            |
| 22289/tcp     | wnn4_Cn                    | cWnn 中文输入系统                                            |
| 22321/tcp     | wnn4_Tw                    | tWnn 中文输入系统（台湾）                                    |
| 24554         | binkp                      | Binkley TCP/IP Fidonet 邮寄程序守护进程                      |
| 27374         | asp                        | 地址搜索协议                                                 |
| 60177         | tfido                      | Ifmail FidoNet 兼容邮寄服务                                  |
| 60179         | fido                       | FidoNet 电子邮件和新闻网络                                   |