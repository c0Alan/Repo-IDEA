################# 这部分脚本只需要在一台服务器上执行一次就行 #################
source ./vars.sh

# 安装依赖ruby
yum -y install ruby ruby-devel rubygems rpm-build
gpg --keyserver hkp://keys.gnupg.net --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3 7D2BAF1CF37B13E2069D6956105BD0E739499BDB 
curl -sSL https://get.rvm.io | bash -s stable

# 安装ruby
source /usr/local/rvm/scripts/rvm
rvm list known              #查看安装版本
rvm install 2.4.1

# 安装gem redis接口
rvm use 2.4.1
rvm use 2.4.1 --default
rvm remove 1.8.7
ruby --version
gem install redis

# 安装rubygems
yum install -y rubygems

# 创建集群
###调用 ruby 命令来进行创建集群，--replicas 1   表示主从复制比例为 1:1，即一个主节点对应一个从节点。
cd /opt/dev/redis/redis-4.0.12/src
redis-trib.rb create --replicas 1 ${clusters}
