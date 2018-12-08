package io.geekidea.fastspringboot;

import io.geekidea.fastspringboot.util.AnsiUtil;
import io.geekidea.fastspringboot.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.Ansi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
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
@EnableAsync
@SpringBootApplication
@MapperScan({"io.geekidea.fastspringboot.*.mapper"})
@Slf4j
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();

        // 项目名称
        String projectFinalName = environment.getProperty("info.project-finalName");
        // 项目版本
        String projectVersion = environment.getProperty("info.project-version");
        // 项目profile
        String profileActive = environment.getProperty("spring.profiles.active");
        // 项目路径
        String contextPath = environment.getProperty("server.servlet.context-path");
        // 项目端口
        String port = environment.getProperty("server.port");

        log.info("projectFinalName : {}",projectFinalName);
        log.info("projectVersion : {}",projectVersion);
        log.info("profileActive : {}",profileActive);
        log.info("contextPath : {}",contextPath);
        log.info("port : {}",port);

        String fastSpringBoot = "______        _     _____            _              ______             _   \n" +
                "|  ___|      | |   /  ___|          (_)             | ___ \\           | |  \n" +
                "| |_ __ _ ___| |_  \\ `--. _ __  _ __ _ _ __   __ _  | |_/ / ___   ___ | |_ \n" +
                "|  _/ _` / __| __|  `--. \\ '_ \\| '__| | '_ \\ / _` | | ___ \\/ _ \\ / _ \\| __|\n" +
                "| || (_| \\__ \\ |_  /\\__/ / |_) | |  | | | | | (_| | | |_/ / (_) | (_) | |_ \n" +
                "\\_| \\__,_|___/\\__| \\____/| .__/|_|  |_|_| |_|\\__, | \\____/ \\___/ \\___/ \\__|\n" +
                "                         | |                  __/ |                        \n" +
                "                         |_|                 |___/                         \n";

        String fastSpringBootBanner = AnsiUtil.getAnsi(Ansi.Color.BLUE,fastSpringBoot) +
                AnsiUtil.getAnsi(Ansi.Color.YELLOW,"  ::    Fast Spring Boot ::         (v" + projectVersion + ")");
        log.info("\n{}\n",fastSpringBootBanner);

        String startSuccess = " ____    __                    __        ____                                                   \n" +
                "/\\  _`\\ /\\ \\__                /\\ \\__    /\\  _`\\                                                 \n" +
                "\\ \\,\\L\\_\\ \\ ,_\\    __     _ __\\ \\ ,_\\   \\ \\,\\L\\_\\  __  __    ___    ___     __    ____    ____  \n" +
                " \\/_\\__ \\\\ \\ \\/  /'__`\\  /\\`'__\\ \\ \\/    \\/_\\__ \\ /\\ \\/\\ \\  /'___\\ /'___\\ /'__`\\ /',__\\  /',__\\ \n" +
                "   /\\ \\L\\ \\ \\ \\_/\\ \\L\\.\\_\\ \\ \\/ \\ \\ \\_     /\\ \\L\\ \\ \\ \\_\\ \\/\\ \\__//\\ \\__//\\  __//\\__, `\\/\\__, `\\\n" +
                "   \\ `\\____\\ \\__\\ \\__/.\\_\\\\ \\_\\  \\ \\__\\    \\ `\\____\\ \\____/\\ \\____\\ \\____\\ \\____\\/\\____/\\/\\____/\n" +
                "    \\/_____/\\/__/\\/__/\\/_/ \\/_/   \\/__/     \\/_____/\\/___/  \\/____/\\/____/\\/____/\\/___/  \\/___/ \n" +
                "                                                                                                \n" +
                "                                                                                                ";

        String homeUrl = "http://" + IpUtil.getLocalhostIp() + ":" + port + contextPath;
        String swaggerUrl = "http://" + IpUtil.getLocalhostIp() + ":" + port + contextPath + "docs";
        log.info("home:{}",homeUrl);
        log.info("docs:{}",swaggerUrl);
        log.info("fast-spring-boot project start success...........");
        log.info("\n{}",AnsiUtil.getAnsi(Ansi.Color.GREEN,startSuccess));
    }

}
