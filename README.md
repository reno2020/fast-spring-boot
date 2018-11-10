# fast-spring-boot

#### fast-spring-boot 项目主页:
   [https://geekidea.io/fast-spring-boot/](https://geekidea.io/fast-spring-boot/)
     
#### fast-spring-boot api 访问地址
   [http://203.104.32.94:8888/api/docs](http://203.104.32.94:8888/api/docs)
     
#### fast-spring-boot GIT地址:
    git@github.com:geekideaio/fast-spring-boot.git
    
#### fast-spring-boot技术栈:
    Jdk 版本 : 1.8
    内嵌Tomcat版本 : 9.0.12
    Spring boot版本 : 2.1.0.RELEASE
    Spring 版本 : 5.1.2.RELEASE
    Mybatis Plus 版本 : 3.0.5
    Mybatis 版本 : 3.4.6
    Mybatis-spring 版本 : 1.3.2
    fastjson 版本 : 1.2.51
    druid 版本 : 1.1.10
    redis 版本 : lettuce5.12.RELEASE

#### 后台主要目录:
	src : 
		common : 公共代码
		config : 配置代码
		system : 系统模块
			entity : 实体类目录
			enums : 枚举包
			exception : 自定义异常
			mapper : mybatis接口
			service : 服务接口
			service.impl : 服务接口实现类
			web.controller : 控制器
			web.param : 请求参数对象
			web.vo : 响应结果对象
		util : 工具集
	
	resources : 
		mapper : mybatis xml目录
			common : 公共xml
			system : 系统模块xml
			
	static :
		Spring Boot UI Admin 登录页面静态资源
		
	application.yml  : 系统公共配置
	application-dev.yml : dev环境配置
	application-local.yml : 本地开发环境配置,连接的dev外网
	application-test.yml : 测试环境配置
	application-uat.yml : uat线上环境配置
	
		
#### 权限拦截器 :  
    io.geekidea.fastspringboot.common.web.interceptor.PermissionInterceptor

#### 前后台交互文档 : swagger
 访问地址 : [http://localhost:8888/api/docs](http://localhost:8888/api/docs)
 
    项目名称 : fast-spring-boot
    项目接口名称 : /api
    端口号 : 8888    
         
####  Spring Boot Admin 
   登录地址 ：[http://localhost:8888/api/login.html](http://localhost:8888/api/login.html)
   
    账号密码同系统登录的账号密码
    账号 ：admin
    密码 ：123456
    
####  枚举类型字典列表
   访问地址 ：[http://localhost:8888/api/doc/dictView](http://localhost:8888/api/doc/dictView)
    
#### 前后台交互参数约定:
    请求参数 : JSON格式
    响应参数 : JSON格式
    响应公共字段:
        {
          "code": 200,
          "msg": "操作成功",
          "data": null,
          "time": "2018-10-19 11:30:00"
        }
    code为200 : 成功
    time:当前响应时间戳
    
    code不为200的情况:
        5001 参数异常
        500  操作失败
        1002 业务异常
        404  未找到对应资源
        1004 没有数据
        403  没有权限
        401  未登录
        4001 第一次登录，需要重置密码
        4002 密码过期
        
#### 前后端请求验证:
    前端请求头设置token，参数名称 : x-auth-token