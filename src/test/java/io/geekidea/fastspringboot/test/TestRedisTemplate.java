package io.geekidea.fastspringboot.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author MrLiu
 * @date 2018/11/10
 */
public class TestRedisTemplate extends BaseTest{

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("hello","Hello Redis...");
    }
}
