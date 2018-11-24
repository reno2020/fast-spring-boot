package io.geekidea.fastspringboot.common.web.interceptor;

import io.geekidea.fastspringboot.common.constant.CommonConstant;
import io.geekidea.fastspringboot.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Token超时拦截器
 * 
 * @author liujixiang
 * @date 2018-11-08
 */
@Slf4j
public class TokenTimeoutInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 如果访问的不是控制器,则跳出,继续执行下一个拦截器
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		// 获取token
		String xAuthToken = request.getHeader(CommonConstant.X_AUTH_TOKEN);
		boolean hasXAuthToken = false;
		if (StringUtils.isNotBlank(xAuthToken)){
			hasXAuthToken = true;
		}
		if (hasXAuthToken == false){
			xAuthToken = request.getParameter(CommonConstant.X_AUTH_TOKEN);
			if (StringUtils.isNotBlank(xAuthToken)){
				hasXAuthToken = true;
			}
		}

		// TODO 排除自动刷新的路径
		if (hasXAuthToken == true){
			// 如果有token,延长时间
			redisTemplate.expire(xAuthToken,LoginUtil.TOKEN_VALID_TIME_MINUTE, TimeUnit.MINUTES);
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}
}