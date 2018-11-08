package io.geekidea.fastspringboot.util;

import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
public class AnsiUtil {

    private static final Logger logger = LoggerFactory.getLogger(AnsiUtil.class);

    private static boolean isEnableAnsi = false;

    static {
        Environment environment = SpringContextUtil.getBean(Environment.class);
        Boolean value = environment.getProperty("fastspringboot.isEnableAnsi",boolean.class);
        if (value != null){
            isEnableAnsi = value;
        }
        logger.info("AnsiUtil isEnableAnsi = " + isEnableAnsi);
    }

    public static String getAnsi(Ansi.Color color,String text){
        if (isEnableAnsi){
            return Ansi.ansi().eraseScreen().fg(color).a(text).reset().toString();
        }
        return text;
    }
}
