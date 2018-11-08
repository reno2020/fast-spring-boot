package io.geekidea.fastspringboot.config;

import io.geekidea.fastspringboot.common.web.interceptor.PermissionInterceptor;
import io.geekidea.fastspringboot.common.web.interceptor.TokenTimeoutInterceptor;
import io.geekidea.fastspringboot.config.httpmessageconverter.ActuatorV2JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

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
        logger.info("PermissionInterceptor excludePaths : {}", Arrays.toString(permissionExcludePaths));
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/*.html")
                .addResourceLocations("classpath:/META-INF/spring-boot-admin-server-ui/");
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/META-INF/spring-boot-admin-server-ui/assets/");

//        registry.addResourceHandler("view/**")
//                .addResourceLocations("classpath:/static/view/");
//        registry.addResourceHandler("res/**")
//                .addResourceLocations("classpath:/static/res/");
//        registry.addResourceHandler("login.html")
//                .addResourceLocations("classpath:/static/login.html");
//        registry.addResourceHandler("login.css")
//                .addResourceLocations("classpath:/static/login.css");
    }


    /**
     * application/vnd.spring-boot.actuator.v2+json 消息转换器
     * @return
     */
    @Bean
    public ActuatorV2JsonConverter actuatorV2JsonConverter(){
        return new ActuatorV2JsonConverter();
    }

}
