package io.geekidea.fastspringboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
@Component
public class RedisCacheUtil {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheUtil.class);

    private static RedisCacheUtil redisCacheUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 将当前对象赋值给静态对象,调用spring组件: redisCacheUtil.redisTemplate.xxx()
     */
    @PostConstruct
    public void init(){
        redisCacheUtil = this;
    }
}
