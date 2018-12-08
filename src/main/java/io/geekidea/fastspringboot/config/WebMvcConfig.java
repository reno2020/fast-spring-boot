package io.geekidea.fastspringboot.config;

import io.geekidea.fastspringboot.common.web.interceptor.PermissionInterceptor;
import io.geekidea.fastspringboot.common.web.interceptor.TokenTimeoutInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${fastspringboot.token.timeout.interceptor.exclude.path}")
    private String[] tokenTimeoutExcludePaths;

    @Value("${fastspringboot.permission.interceptor.exclude.path}")
    private String[] permissionExcludePaths;

    /**
     * 权限拦截器
     * @return
     */
    @Bean
    public PermissionInterceptor permissionInterceptor(){
        return new PermissionInterceptor();
    }

    /**
     * TOKEN超时拦截器
     * @return
     */
    @Bean
    public TokenTimeoutInterceptor tokenTimeoutInterceptor(){
        return new TokenTimeoutInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("PermissionInterceptor excludePaths : {}", Arrays.toString(permissionExcludePaths));
        // 1.TOKEN超时拦截器
//        registry.addInterceptor(tokenTimeoutInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(tokenTimeoutExcludePaths);
//
//        // 2.权限拦截器
//        registry.addInterceptor(permissionInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(permissionExcludePaths)
//                .excludePathPatterns(operationPlatformIncludePaths);

    }

}
