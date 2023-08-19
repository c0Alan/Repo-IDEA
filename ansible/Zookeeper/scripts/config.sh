#!/bin/bash

source ./publicVar.sh

mkdir -p ${home}/data
echo ${myid} > ${home}/data/myid

cd ${home}/${packageDir}/conf

if [ ! -e "zoo.cfg" ]; then
 cp zoo_sample.cfg zoo.cfg
fi

sed -i "/^tickTime=/d" zoo.cfg
echo "tickTime=$tickTime" >> zoo.cfg

sed -i "/^initLimit=/d" zoo.cfg
echo "initLimit=$initLimit" >> zoo.cfg

sed -i "/^syncLimit=/d" zoo.cfg
echo "syncLimit=$syncLimit" >> zoo.cfg

sed -i "/^dataDir=/d" zoo.cfg
echo "dataDir=$dataDir" >> zoo.cfg

sed -i "/^dataLogDir=/d" zoo.cfg
echo "dataLogDir=$dataLogDir" >> zoo.cfg

sed -i "/^clientPort=/d" zoo.cfg
echo "clientPort=$clientPort" >> zoo.cfg

sed -i "/^server.*=/d" zoo.cfg

for server in $servers;  
do
echo "$server" >> zoo.cfg
done 
