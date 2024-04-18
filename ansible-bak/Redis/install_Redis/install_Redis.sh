source ./vars.sh

mkdir -p /opt/dev/redis
cd /opt/dev/redis

if [ ! -f "redis-4.0.12.tar.gz" ];then
	wget -c http://download.redis.io/releases/redis-4.0.12.tar.gz
fi
tar -zxvf redis-4.0.12.tar.gz
cd redis-4.0.12
make && make install

cd src
cp -f redis-trib.rb /usr/local/bin

mkdir -p ${installHome}

for port in ${ports};
do
	mkdir -p ${installHome}/${port}
	mkdir -p ${installHome}/${port}/logs
	touch ${installHome}/${port}/logs/redis_${port}.log
	mkdir -p ${installHome}/${port}/data

	cp ${packageHome}/redis.conf ${installHome}/${port}
	sed -i "/^port [0-9]\+/s/[0-9]\+/${port}/g" ${installHome}/${port}/redis.conf
	sed -i "/^bind [0-9]\+.*/s/[0-9]\+.*/${host}/g" ${installHome}/${port}/redis.conf
	sed -i "/^daemonize .*/s/^daemonize .*/daemonize yes/g" ${installHome}/${port}/redis.conf
	sed -i "/^pidfile .*/s/.*/pidfile \/usr\/local\/redis-4.0.12-cluster\/${port}\/redis_${port}.pid/g" ${installHome}/${port}/redis.conf
	sed -i "/^# cluster-enabled/s/# //g" ${installHome}/${port}/redis.conf
	sed -i "/^# cluster-config-file/s/.*/cluster-config-file nodes_${port}.conf/g" ${installHome}/${port}/redis.conf
	sed -i "/^# cluster-node-timeout/s/# //g" ${installHome}/${port}/redis.conf
	sed -i "/^appendonly /s/^appendonly.*/appendonly yes/g" ${installHome}/${port}/redis.conf
	sed -i "/^logfile /s/^logfile.*/logfile \"\/usr\/local\/redis-4.0.12-cluster\/${port}\/logs\/redis_${port}.log\"/g" ${installHome}/${port}/redis.conf
	sed -i "/^dir /s/^dir.*/dir \"\/usr\/local\/redis-4.0.12-cluster\/${port}\/data\"/g" ${installHome}/${port}/redis.conf

	cp ${packageHome}/src/redis-cli ${packageHome}/src/redis-server ${installHome}/$port
done



# if [ $? -eq 0 ]; then
	# echo export PATH=$PATH:/usr/local/erlang/bin >> /etc/profile
	# source /etc/profile
# fi

