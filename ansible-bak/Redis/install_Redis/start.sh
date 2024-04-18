source ./vars.sh
cd ${packageHome}/src

for port in ${ports};
do
	redis-server ${installHome}/${port}/redis.conf
done