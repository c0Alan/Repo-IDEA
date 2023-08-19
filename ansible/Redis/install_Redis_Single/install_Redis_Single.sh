source ./vars.sh

mkdir -p /opt/dev/redis
cd /opt/dev/redis

if [ ! -f "redis-4.0.12.tar.gz" ];then
	wget -c http://download.redis.io/releases/redis-4.0.12.tar.gz
fi
tar -zxvf redis-4.0.12.tar.gz
cd redis-4.0.12
make && make install

cp ${packageHome}/redis.conf ${installHome}

sed -i "/^bind [0-9]\+.*/s/[0-9]\+.*/${host}/g" ${installHome}/redis.conf
sed -i "/^daemonize .*/s/^daemonize .*/daemonize yes/g" ${installHome}/redis.conf


