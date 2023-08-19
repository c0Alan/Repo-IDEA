mkdir -p /opt/dev/rabbitmq
cd /opt/dev/rabbitmq
# 安装Erlang环境
yum install gcc glibc-devel make ncurses-devel openssl-devel xmlto

if [ ! -f "otp_src_20.2.tar.gz" ];then
	wget -c http://erlang.org/download/otp_src_20.2.tar.gz
fi
tar -zxvf otp_src_20.2.tar.gz
cd otp_src_20.2/
./configure --prefix=/usr/local/erlang
make && make install

if [ $? -eq 0 ]; then
	echo export PATH=$PATH:/usr/local/erlang/bin >> /etc/profile
	source /etc/profile
fi

# 安装rabbitmq
cd ..
if [ ! -f "rabbitmq-server-generic-unix-3.6.15.tar.xz" ];then
	wget -c http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.15/rabbitmq-server-generic-unix-3.6.15.tar.xz
fi
xz -d rabbitmq-server-generic-unix-3.6.15.tar.xz
tar -xvf rabbitmq-server-generic-unix-3.6.15.tar

if [ $? -eq 0 ]; then
	echo export PATH=$PATH:/usr/local/rabbitmq_server-3.6.15/sbin >> /etc/profile
	source /etc/profile
fi
