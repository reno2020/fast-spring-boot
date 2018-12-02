#======================================================================
# windows启动脚本
#
# author: liujixiang
# date: 2018-12-2
#======================================================================

rem startup jar
java -jar ../boot/fast-spring-boot.jar --spring.config.location=../config/ --fastspringboot.isEnableAnsi=false

pause