package io.geekidea.fastspringboot.common.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求路径过滤器
 * @author liujixiang
 * @date 2018-11-08
 */
public class RequestPathFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(RequestPathFilter.class);

    private static List<String> excludes = new ArrayList<>();

    static {
        excludes.add("/api");
        excludes.add("/health/");
        excludes.add("/logfile");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();
        String url = req.getRequestURL().toString();
        boolean isOut = true;
        for (String p : excludes){
            if (path.startsWith(p)){
                isOut = false;
                break;
            }
        }
        if (isOut){
            logger.debug("requestURL:"+url);
        }
        chain.doFilter(req,response);
    }

    @Override
    public void destroy() {

    }
}
