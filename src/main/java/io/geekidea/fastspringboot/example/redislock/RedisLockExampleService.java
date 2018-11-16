package io.geekidea.fastspringboot.example.redislock;

import io.geekidea.fastspringboot.system.entity.SysLog;

/**
 * Redis分布式锁示例服务接口
 * @author liujixiang
 * @date 2018/11/14
 */
public interface RedisLockExampleService {

    /**
     * 修改
     * @param sysLog
     * @return
     */
    boolean update(SysLog sysLog);
}
