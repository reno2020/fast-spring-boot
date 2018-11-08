package io.geekidea.fastspringboot.config;

import io.geekidea.fastspringboot.common.web.filter.CrossDomainFilter;
import io.geekidea.fastspringboot.common.web.filter.RequestPathFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;


/**
 * @author liujixiang
 * @date 2018-11-08
 */
@Configuration
public class FilterConfig {


    @Bean
    public Filter crossDomainFilter(){
        return new CrossDomainFilter();
    }

//    @Bean
//    public Filter springBootAdminFilter(){
//        return new SpringBootAdminFilter();
//    }

    @Bean
    public Filter requestPathFilter(){
        return new RequestPathFilter();
    }

    @Bean
    @Order(1)
    public FilterRegistrationBean requestPathFilterBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(requestPathFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    @Order(2)
    public FilterRegistrationBean crossDomainFilterBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(crossDomainFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

//    @Bean
//    @Order(3)
//    public FilterRegistrationBean springBootAdminFilterBean() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(springBootAdminFilter());
//        registration.addUrlPatterns(
//                "/index.html",
//                "/api/applications/views/*",
//                "/api/applications-details/views/details.html",
//                "/api/applications-logfile/views/logfile.html",
//                "/api/applications-metrics/views/metrics.html",
//                "/api/applications-environment/views/environment.html",
//                "/api/applications-logging/views/logging.html",
//                "/api/applications-jmx/views/jmx.html",
//                "/api/applications-threads/views/threads.html",
//                "/api/applications-auditevents/auditevents.html",
//                "/api/applications-trace/views/trace.html",
//                "/api/applications/*/logfile",
//                "/api/applications/*/env");
//        return registration;
//    }
}
