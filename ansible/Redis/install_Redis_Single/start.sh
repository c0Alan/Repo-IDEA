source ./vars.sh
cd ${packageHome}/src

redis-server ${installHome}/redis.conf
