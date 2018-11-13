package io.geekidea.fastspringboot.common.web.controller;

import io.geekidea.fastspringboot.common.api.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 *     项目根路径提示信息
 * </p>
 * @author liujixiang
 * @date 2018/11/12
 */
@RestController
@ApiIgnore
@Slf4j
public class IndexController {

    @RequestMapping("/")
    public ApiResult<String> index(){
        log.debug("index...");
        return ApiResult.ok("Welcome to Fast Spring Boot Project...");
    }
}
