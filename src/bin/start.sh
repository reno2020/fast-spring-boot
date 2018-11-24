#! /bin/shell

java -jar ../boot/fast-spring-boot.jar --spring.config.location=../config/application.yml,../config/application-local.yml
 > logs/fast-spring-boot.log &