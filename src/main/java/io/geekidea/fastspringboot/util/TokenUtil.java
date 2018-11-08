package io.geekidea.fastspringboot.util;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
public class TokenUtil {

    /**
     * 生成token
     * @return
     */
    public static String generateXAuthToken(){
        String token = "x-auth-token:" + UUIDUtil.getUUID();
        return token;
    }

    /**
     * 生成token
     * @return
     */
    public static String generateFirstLoginRestPwdToken(){
        String token = "first-login-rest-pwd-token:" + UUIDUtil.getUUID();
        return token;
    }

    /**
     * 生成验证码token
     * @return
     */
    public static String generateVerificationCodeToken(){
        String token = "verification-code-token:" + UUIDUtil.getUUID();
        return token;
    }
}
