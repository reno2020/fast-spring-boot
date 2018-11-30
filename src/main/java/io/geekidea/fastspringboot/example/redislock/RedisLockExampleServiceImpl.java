package io.geekidea.fastspringboot.example.redislock;

import io.geekidea.fastspringboot.system.entity.SysLog;
import io.geekidea.fastspringboot.system.mapper.SysLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean update(SysLog sysLog) {
        // 使用redisTemplate setIfAbsent实现简单的分布式锁
        // TODO 使用AOP切面优化
        String redisKey = String.valueOf(sysLog.getLogId());
        Boolean flag = redisTemplate.opsForValue().setIfAbsent(redisKey,sysLog.toString(),1, TimeUnit.MINUTES);
        if (!flag){
            throw new RuntimeException("该ID已经在修改，请稍后再试。");
        }

        log.debug("update...");
        int result = sysLogMapper.updateById(sysLog);
        log.debug("result:" + result);
        return result == 1;
    }

}
