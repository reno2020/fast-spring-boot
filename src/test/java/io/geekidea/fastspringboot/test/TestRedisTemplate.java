package io.geekidea.fastspringboot.test;

import io.geekidea.fastspringboot.example.redislock.RedisLockExampleService;
import io.geekidea.fastspringboot.system.entity.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author MrLiu
 * @date 2018/11/10
 */
@Slf4j
public class TestRedisTemplate extends BaseTest{

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisLockExampleService redisLockExampleService;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("hello","Hello Redis...");
        Object hello = redisTemplate.opsForValue().get("hello");
        log.debug("hello = " + hello);
    }


    @Test
    public void concurrentTest(){
        log.debug("concurrentTest...");
        int count = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executorService.execute(() -> {
                        log.debug(finalI+"");
                String key = "hello"+finalI;
                redisTemplate.opsForValue().set(key,"Hello Redis..."+finalI);
                Object hello = redisTemplate.opsForValue().get(key);
                log.debug(hello+"");
            }

            );
        }

    }


    @Test
    public void concurrentTestUpdate(){
        log.debug("concurrentTestUpdate...");
        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executorService.execute(() -> {
                log.debug("i = " + finalI);
                SysLog sysLog = new SysLog();
                sysLog.setLogId(1060439085228830721L);
                sysLog.setContent("test redis lock " + LocalDateTime.now());
                sysLog.setCreateTime(LocalDateTime.now());
                sysLog.setType(true);
                redisLockExampleService.update(sysLog);
            }

            );
        }

    }


}
