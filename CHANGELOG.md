# fast-spring-boot CHANGELOG

## [v0.x] 
- 优化AOP日志处理
- log输出到mongodb
- scheduled
- Email
- security
- flyway 数据库版本管理
- 数据表枚举类型自动映射
- 用户角色权限管理
- 登录权限拦截器
- 数据字典


## [v0.5] 2018.11.24
- 使用maven assembly插件打包
- 启动提示优化,fast spring boot banner
- 启动成功打印主页API访问地址和swagger api docs访问地址
- 将全部的System.out.println()替换成log.debug或者log.info
- 将Logger全部替换成@Slf4j

## [v0.4] 2018.11.13
- Kafka配置和使用示例

## [v0.3] 2018.11.12
- RabbitMQ配置和使用示例

## [v0.2] 2018.11.10
- 修改getById方法主键类型为Serializable
- 优化分页方法
- 优化代码生成器，自定义实体对象名称属性
- 优化主键名称不是id时的支持

## [v0.1] 2018.11.08
- init framework
