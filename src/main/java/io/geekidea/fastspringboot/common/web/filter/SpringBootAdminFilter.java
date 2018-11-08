package io.geekidea.fastspringboot.common.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
public class SpringBootAdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

//        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) req.getSession().getAttribute(CommonConstant.ADMIN_LOGIN);
//        if (loginSysUserVo == null){
////            try {
////                //HttpServletResponseUtil.printJSON(resp,new ResponseResult(ResponseCode.NOT_LOGIN,"会话已失效,请重新登录"));
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//            resp.sendRedirect("/api/login.html");
//            return;
//        }

        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
