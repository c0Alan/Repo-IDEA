#!/bin/bash

baseDir=$(cd `dirname $0` && pwd)
cd $baseDir

# 模块路径
MODEL_DIR=$1
MODEL_PACKAGE=${MODEL_DIR}'.tar.gz'

#----------------------------------------------------------
# function install
#----------------------------------------------------------
install()
{

if [ ! -n "$1" ] ;then
    echo "you have not input a word!"
	return 1
else
    echo "star install $1 >>>>>>"
fi

if [ -d "${MODEL_DIR}" ]                                                   
then
echo "${MODEL_DIR} exists, star upgrade $1 >>>>>>"
echo "stop"
model_stop
echo "stop"
#cp ${MODEL_DIR}/conf/application-prod.properties .
tar -zxvf ${MODEL_PACKAGE}
#mv application-prod.properties ${MODEL_DIR}/conf
# rm -f ${MODEL_PACKAGE}
else
tar -zxvf ${MODEL_PACKAGE}
# rm -f ${MODEL_PACKAGE}
fi

model_start

}

model_start()
{
cd ${MODEL_DIR}
sh bin/run.sh start
}

model_stop()
{
cd ${MODEL_DIR}
sh bin/run.sh stop
cd ..
}


#-------------------------------------------------------------------
# main
#-------------------------------------------------------------------

install $1

echo aa
