package io.geekidea.fastspringboot.util;

import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.Ansi;
import org.springframework.core.env.Environment;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
@Slf4j
public class AnsiUtil {

    private static boolean isEnableAnsi = false;

    static {
        Environment environment = SpringContextUtil.getBean(Environment.class);
        Boolean value = environment.getProperty("fastspringboot.isEnableAnsi",boolean.class);
        if (value != null){
            isEnableAnsi = value;
        }
        log.info("AnsiUtil isEnableAnsi = " + isEnableAnsi);
    }

    public static String getAnsi(Ansi.Color color,String text){

        if (isEnableAnsi){
            return Ansi.ansi().eraseScreen().fg(color).a(text).reset().toString();
        }
        return text;
    }
}
