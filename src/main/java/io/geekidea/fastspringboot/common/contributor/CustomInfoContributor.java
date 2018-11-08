package io.geekidea.fastspringboot.common.contributor;

import io.geekidea.fastspringboot.common.service.MySQLInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * 自定义显示info信息，spring-boot-admin ui显示
 * @author liujixiang
 * @date 2018-11-08
 */
@Component
public class CustomInfoContributor implements InfoContributor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomInfoContributor.class);

    @Autowired
    private MySQLInfoService mySQLInfoService;

    @Override
    public void contribute(Info.Builder builder) {
        String version = mySQLInfoService.getVersion();
        builder.withDetail("project-mysql-version",version).build();
    }

}
