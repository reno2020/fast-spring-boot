# 九、分布式集群部署

1.服务器软硬件配置推荐
  - 服务商：阿里云
  - 系统：CentOS 7
  - CPU数量：4V
  - 内存：16G
  - 带宽：10M
  
2.部署网络拓扑图

3.服务器最低部署推荐(共计9台)
  - 数据库2台
  - Redis2台
  - 应用部署2台
  - 消息队列2台
  - DevOps 1台
  
4.使用Jenkins持续集成发布

5.使用阿里云负载均衡产品

6.如数据库性能要求较高，推荐使用阿里云DRDS(分布式关系型数据库服务)

7.短信验证码可使用阿里云服务

8.图片文件资源等可使用阿里云OSS服务