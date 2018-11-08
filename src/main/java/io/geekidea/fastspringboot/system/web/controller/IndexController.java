package io.geekidea.fastspringboot.system.web.controller;

import io.geekidea.fastspringboot.common.api.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author liujixiang
 * @date 2018/11/8
 */
@RestController
@ApiIgnore
public class IndexController {

    @RequestMapping("/")
    public ApiResult index(){
        System.out.println("index...");
        return ApiResult.ok("Welcome to FastSpringBoot Project Index...");
    }

}
