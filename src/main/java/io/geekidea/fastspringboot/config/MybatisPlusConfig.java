package io.geekidea.fastspringboot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *     MybatisPlus配置
 * </p>
 * @author liujixiang
 * @since 2018-11-08
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
