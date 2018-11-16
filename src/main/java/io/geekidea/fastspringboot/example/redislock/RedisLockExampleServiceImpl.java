package io.geekidea.fastspringboot.example.redislock;

import io.geekidea.fastspringboot.system.entity.SysLog;
import io.geekidea.fastspringboot.system.mapper.SysLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Redis分布式锁示例服务实现
 * @author liujixiang
 * @date 2018/11/14
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class RedisLockExampleServiceImpl implements RedisLockExampleService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Klock
    @Override
    public boolean update(SysLog sysLog) {
        System.out.println("update...");
        int result = sysLogMapper.updateById(sysLog);
        System.out.println("result:" + result);
        return result == 1;
    }

}
