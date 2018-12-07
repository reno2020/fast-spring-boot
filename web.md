# 五、前后端交互方案

#### 前后台交互文档 : swagger
 访问地址 : [http://fast-spring-boot.cfapps.io/docs](http://fast-spring-boot.cfapps.io/docs)
 
    项目名称 : fast-spring-boot
    项目接口名称 : /api
    端口号 : 8888


####  枚举类型字典列表
   访问地址 ：[http://fast-spring-boot.cfapps.io/doc/dictView](http://fast-spring-boot.cfapps.io/doc/dictView)
    
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
