package io.geekidea.fastspringboot.test;

import io.geekidea.fastspringboot.example.redislock.RedisLockExampleService;
import io.geekidea.fastspringboot.system.entity.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liujixiang
 * @date 2018/11/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestRedisLock {

    @Autowired
    private RedisLockExampleService redisLockExampleService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws InterruptedException {
        redisTemplate.opsForValue().set("hello","Hello Redis...");
        Object hello = redisTemplate.opsForValue().get("hello");
        System.out.println("hello = " + hello);

        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println("i:"+finalI);
                SysLog sysLog = new SysLog();
                sysLog.setLogId(1060439085228830721L);
                sysLog.setContent("test redis lock " + LocalDateTime.now());
                sysLog.setCreateTime(LocalDateTime.now());
                sysLog.setType(true);
                System.out.println("sysLog:"+sysLog);
                boolean flag = redisLockExampleService.update(sysLog);
                System.out.println("flag:"+flag);
                if (flag){
                    System.out.println("修改成功");
                }else{
                    System.out.println("修改失败");
                }
            }

            );
        }

        Thread.sleep(10000);



    }


    @Test
    public void testRedisSetNx() throws InterruptedException {
        String key = "testRedisSetNx_123";
        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executorService.execute(() -> {
                        System.out.println("i:"+finalI);
                        SysLog sysLog = new SysLog();
                        sysLog.setLogId(1060439085228830721L);
                        sysLog.setContent("test redis setNx " + LocalDateTime.now());
                        sysLog.setCreateTime(LocalDateTime.now());
                        sysLog.setType(true);
                        System.out.println("sysLog:"+sysLog);
                        boolean flag = redisTemplate.opsForValue().setIfAbsent(key,"123...",5, TimeUnit.MINUTES);
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("flag:"+flag);
                        if (flag){
                            System.out.println("设置成功");
                        }else{
                            System.out.println("设置失败");
                        }
                    }

            );
        }

        Thread.sleep(10000);



    }




}
