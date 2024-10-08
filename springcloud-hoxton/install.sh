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
      echo "请输入模块名!"
    return 1
  else
      echo "开始部署或升级 $1 >>>>>>"
  fi

  if [ -d "${MODEL_DIR}" ]
  then
    echo "模块：${MODEL_DIR} 已存在, 开始升级 >>>>>>"
    #cp ${MODEL_DIR}/conf/application-prod.properties .
    rm -rf ${MODEL_DIR}
    tar -zxvf ${MODEL_PACKAGE}
    #mv application-prod.properties ${MODEL_DIR}/conf
    # rm -f ${MODEL_PACKAGE}
  else
    tar -zxvf ${MODEL_PACKAGE}
    # rm -f ${MODEL_PACKAGE}
  fi
}

model_start()
{
  echo "启动模块：${MODEL_DIR}"
  cd ${MODEL_DIR}
  sh bin/run.sh start
}

model_stop()
{
  echo "停止模块：${MODEL_DIR}"
  cd ${MODEL_DIR}
  sh bin/run.sh stop
  cd ..
}


#-------------------------------------------------------------------
# main
#-------------------------------------------------------------------

install $1

