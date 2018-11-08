package io.geekidea.fastspringboot.common.exception;

import io.geekidea.fastspringboot.common.api.ApiCode;
import io.geekidea.fastspringboot.common.api.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 全局Error/404处理
 * @author liujixiang
 * @date 2018-11-08
 */
@ApiIgnore
@RestController
public class GlobalErrorController implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(GlobalErrorController.class);

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public ApiResult handleError(){
        logger.error("404 NOT FOUND");
        return ApiResult.failed(ApiCode.FAILED);
    }

    @Override
    public String getErrorPath() {
        logger.error("errorPath....");
        return ERROR_PATH;
    }
}
