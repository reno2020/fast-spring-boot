#! /bin/shell

PID=$(ps -ef | grep fast-spring-boot.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill  $PID
    kill -9 $PID
    echo fast-spring-boot stopped successfully
fi