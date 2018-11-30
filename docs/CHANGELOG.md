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

## [v0.6] 2018.11.30
- 控制器方法默认加上@Valid参数校验注解
- 优化参数校验异常,输出字段校验错误信息
- 优化代码生成器模板格式和多余的导入
- 使用javax.validation包作为属性校验器，如:@NotBlank

- 新增pom-assembly.xml:打包成tar.gz
- pom.xml打包成原生spring boot jar
- 新增stop.sh,restart.sh shell脚本
- sys_log.sql数据表初始化脚本,在resources/db目录中

- 新增manifest.yml,pivotal.io公有云配置文件
- 新增application-pivotal.yml配置文件,配置pivotal中使用的mysql,redis,rabbitmq服务相关信息
- pivotal.io使用文档
    - pivotal.io 可以免费发布spring boot.jar应用,并可免费使用mysql/redis/rabbitmq等服务
    - 注册：https://account.run.pivotal.io/z/uaa/sign-up
    - 登录控制台：https://console.run.pivotal.io/ 进入组织，会提供2个G的内存
    - 命令行上传jar到pivotal.io步骤：https://pivotal.io/platform/pcf-tutorials/getting-started-with-pivotal-cloud-foundry/introduction
    - 如何开通mysql/redis/rabbitmq:控制台的MarketPlace中搜索mysql,rabbit,redis，然后创建
    - 创建之后再组织的service中可以查看一创建的服务，并可进入其控制台查看连接地址等信息
    - 在组织中，还可以查看对应应用的运行日志

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
