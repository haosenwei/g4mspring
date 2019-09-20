#!/bin/sh

#判断命令行参数,不符合条件则退出
#第一个参数 ACTION 类型 compile:拉取代码和编译，build:生成镜像，push:上传镜像,run:镜像运行，auto:自动执行所有步骤
#第二个参数 Tag名称 可以不传默认拉取最新TAG。
#镜像默认用DEV配置，随后上线部署时通过confgmag外挂目录

WORKSPACE=$(cd `dirname $0`; pwd)
COMPILE_DIR=${WORKSPACE}
OUTPUT_DIR=${COMPILE_DIR}/target
TOMCAT_DIR=~/tomcat
PORT=`ps -ef | grep tomcat | grep java | awk '{print $2}'`
kill -9 ${PORT}
rm -rf ${TOMCAT_DIR}/webapps/*
mv ${OUTPUT_DIR}/ROOT.war ${TOMCAT_DIR}/webapps/
sh ${TOMCAT_DIR}/bin/startup.sh
echo 'run tomcat'
exit
