package io.geekidea.fastspringboot.example.redislock;

import io.geekidea.fastspringboot.common.api.ApiResult;
import io.geekidea.fastspringboot.system.entity.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Redis分布式锁示例控制器
 * @author liujixiang
 * @date 2018/11/14
 */
@RestController
@RequestMapping("/redisLock")
@Slf4j
public class RedisLockController {

    @Autowired
    private RedisLockExampleService redisLockExampleService;

    @GetMapping("/update")
    public ApiResult<String> update(){

        SysLog sysLog = new SysLog();
        sysLog.setLogId(1060439085228830721L);
        sysLog.setContent("test redis lock " + LocalDateTime.now());
        sysLog.setCreateTime(LocalDateTime.now());
        sysLog.setType(true);
        boolean flag = redisLockExampleService.update(sysLog);
        if (flag){
            return ApiResult.ok("修改成功");
        }

        return ApiResult.failed("修改失败");
    }

    @GetMapping("/concurrentUpdate")
    public ApiResult<String> concurrentUpdate(){
        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executorService.execute(() -> {
                        System.out.println("i = " + finalI);
                        SysLog sysLog = new SysLog();
                        sysLog.setLogId(1060439085228830721L);
                        sysLog.setContent("test redis lock " + UUID.randomUUID().toString());
                        sysLog.setCreateTime(LocalDateTime.now());
                        sysLog.setType(true);
                        System.out.println("sysLog = " + sysLog);
                        boolean flag = redisLockExampleService.update(sysLog);
                        System.out.println("flag = " + flag);
                        if (flag){
                            System.out.println("修改成功");
                        }else{
                            System.out.println("修改失败");
                        }
                    }

            );
        }

        return ApiResult.ok("响应ok...");
    }
}
