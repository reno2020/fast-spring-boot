package io.geekidea.fastspringboot.common.api;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * ApiResultEST API 公共控制器
 * </p>
 *
 * @author liujixiang
 * @since 2018-11-08
 */
@Slf4j
public class ApiController {

    /**
     * <p>
     * 请求成功
     * </p>
     *
     * @param data 数据内容
     * @param <T>  对象泛型
     * @return
     */
    protected <T> ApiResult<T> success(T data) {
        return ApiResult.ok(data);
    }

    /**
     * <p>
     * 请求失败
     * </p>
     *
     * @param msg 提示内容
     * @return
     */
    protected ApiResult<Object> failed(String msg) {
        return ApiResult.failed(msg);
    }

    /**
     * <p>
     * 请求失败
     * </p>
     *
     * @param errorCode 请求错误码
     * @return
     */
    protected ApiResult<Object> failed(IErrorCode errorCode) {
        return ApiResult.failed(errorCode);
    }

}
