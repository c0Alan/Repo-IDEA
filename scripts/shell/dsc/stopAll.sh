#!/bin/bash

baseDir=$(cd `dirname $0` && pwd)
cd $baseDir

#----------------------------------------------------------
# function install
#----------------------------------------------------------
stop_all()
{

for file in `ls .`
do
if [ -d $file ]
then
echo "stop $file"
cd $file
sh bin/run.sh stop
cd ..
fi
done


}


#-------------------------------------------------------------------
# main
#-------------------------------------------------------------------

stop_all

