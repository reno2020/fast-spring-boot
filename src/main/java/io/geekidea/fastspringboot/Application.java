package io.geekidea.fastspringboot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.geekidea.fastspringboot.util.AnsiUtil;
import io.geekidea.fastspringboot.util.IpUtil;
import io.geekidea.fastspringboot.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.Ansi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Fast Spring Boot 项目启动入口
 * @author liujixiang
 * @since 2018-11-08
 */
@EnableTransactionManagement
@EnableConfigurationProperties
@EnableScheduling
@EnableAdminServer
@SpringBootApplication
@MapperScan({"io.geekidea.fastspringboot.*.mapper"})
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);

        Environment environment = SpringContextUtil.getBean(Environment.class);
        log.info("profileActive = " + environment.getProperty("spring.profiles.active"));
        log.info("fast-spring-boot project start success...........");

        String startSuccess = " ____    __                    __        ____                                                   \n" +
                "/\\  _`\\ /\\ \\__                /\\ \\__    /\\  _`\\                                                 \n" +
                "\\ \\,\\L\\_\\ \\ ,_\\    __     _ __\\ \\ ,_\\   \\ \\,\\L\\_\\  __  __    ___    ___     __    ____    ____  \n" +
                " \\/_\\__ \\\\ \\ \\/  /'__`\\  /\\`'__\\ \\ \\/    \\/_\\__ \\ /\\ \\/\\ \\  /'___\\ /'___\\ /'__`\\ /',__\\  /',__\\ \n" +
                "   /\\ \\L\\ \\ \\ \\_/\\ \\L\\.\\_\\ \\ \\/ \\ \\ \\_     /\\ \\L\\ \\ \\ \\_\\ \\/\\ \\__//\\ \\__//\\  __//\\__, `\\/\\__, `\\\n" +
                "   \\ `\\____\\ \\__\\ \\__/.\\_\\\\ \\_\\  \\ \\__\\    \\ `\\____\\ \\____/\\ \\____\\ \\____\\ \\____\\/\\____/\\/\\____/\n" +
                "    \\/_____/\\/__/\\/__/\\/_/ \\/_/   \\/__/     \\/_____/\\/___/  \\/____/\\/____/\\/____/\\/___/  \\/___/ \n" +
                "                                                                                                \n" +
                "                                                                                                ";

        System.out.println(AnsiUtil.getAnsi(Ansi.Color.GREEN,startSuccess));
        String url = "http://" + IpUtil.getLocalhostIp() + ":8888/api";
        System.out.println(AnsiUtil.getAnsi(Ansi.Color.GREEN,url));
    }

}
