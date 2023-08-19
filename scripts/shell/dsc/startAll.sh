#!/bin/bash

baseDir=$(cd `dirname $0` && pwd)
cd $baseDir

#----------------------------------------------------------
# function install
#----------------------------------------------------------
start_all()
{

for file in `ls .`
do
if [ -d $file ]
then
echo "start $file"
cd $file
sh bin/run.sh start
cd ..
fi
done


}


#-------------------------------------------------------------------
# main
#-------------------------------------------------------------------

start_all

