package io.geekidea.fastspringboot.common.constant;

/**
 * 响应码
 *
 * @author liujixiang
 * @date 2018-11-08
 */
public interface ResponseCode {

    /**
     * 参数异常
     */
    Integer PARAMETER_EXCEPTION = 5001;

    /**
     * 操作成功
     */
    Integer SUCCESS = 200;
    /**
     * 操作失败
     */
    Integer ERROR = 500;

    /**
     * 数据库异常
     */
    Integer DAO_EXCEPTION = 1001;
    /**
     * 业务类异常
     */
    Integer BUSINESS_EXCEPTION = 1002;
    /**
     * 未找到对应资源404
     */
    Integer NOT_FOUND = 404;
    /**
     * 未知异常
     */
    String UNKNOWN_EXCEPTION = "UNKNOWN_EXCEPTION";
    /**
     * 没有结果
     */
    Integer NOT_RESULT = 1004;

    /**
     * 没有权限
     */
    Integer NOT_PERMISSION = 403;

    /**
     * IP不允许访问
     */
    String IP_NOT_ALLOWED_ACCESS = "IP_NOT_ALLOWED_ACCESS";

    /**
     * 没有TOKEN
     */
    String NOT_TOKEN = "NOT_TOKEN";

    /**
     * TOKEN错误
     */
    String TOKEN_ERROR = "TOKEN_ERROR";

    /**
     * 登录失败
     */
    String LOGIN_FAIL = "LOGIN_FAIL";

    /**
     * 未登录
     */
    Integer NOT_LOGIN = 401;

    /**
     * 为完善资料
     */
    Integer NOT_INFO_PERFECT = 402;

    /**
     * 第一次登录，需要重置密码
     */
    Integer FIRST_LOGIN_REST_PWD = 4001;

    /**
     * 密码过期
     */
    Integer PWD_EXPIRE = 4002;
}
