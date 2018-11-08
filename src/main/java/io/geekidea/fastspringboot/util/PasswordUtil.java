package io.geekidea.fastspringboot.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 密码加密工具类
 * @author liujixiang
 * @date 2018-11-08
 */
public class PasswordUtil {
    private static final String KEY = "io.geekidea.fastspringboot.fastspringboot.pwd.key";
    public static String encrypt(String pwd){
        if (StringUtils.isBlank(pwd)){
            return null;
        }
        pwd = pwd + KEY;
        String newPwd = DigestUtils.sha256Hex(pwd) + DigestUtils.md5Hex(pwd);
        return newPwd;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("7c4a8d09ca3762af61e59520943dc26494f8941b"));
    }
}
