package io.geekidea.fastspringboot.common.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

/**
 * <p>
 * REST API 返回结果
 * </p>
 *
 * @author liujixiang
 * @since 2018-11-08
 */
@Data
@Accessors(chain = true)
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 9176125179872407986L;

    @ApiModelProperty("响应码")
    private long code;

    @ApiModelProperty("响应数据")
    private T data;

    @ApiModelProperty("响应消息")
    private String msg;

    @ApiModelProperty("响应时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time = new Date();

    public ApiResult() {
    }

    public ApiResult(IErrorCode errorCode) {
        errorCode = Optional.ofNullable(errorCode).orElse(ApiCode.FAILED);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public static <T> ApiResult<T> ok(T data) {
        ApiCode aec = ApiCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            aec = ApiCode.FAILED;
        }
        return restResult(data, aec);
    }

    public static <T> ApiResult<T> failed(String msg) {
        return restResult(null, ApiCode.FAILED.getCode(), msg);
    }

    public static <T> ApiResult<T> failed(IErrorCode errorCode) {
        return restResult(null, errorCode);
    }

    public static <T> ApiResult<T> failed(IErrorCode errorCode,T data) {
        return restResult(data, errorCode);
    }

    public static <T> ApiResult<T> restResult(T data, IErrorCode errorCode) {
        return restResult(data, errorCode.getCode(), errorCode.getMsg());
    }

    private static <T> ApiResult<T> restResult(T data, long code, String msg) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public boolean ok() {
        return ApiCode.SUCCESS.getCode() == code;
    }

    /**
     * 服务间调用非业务正常，异常直接释放
     */
    public T serviceData() {
        if (!ok()) {
            throw new ApiException(this.msg);
        }
        return data;
    }
}
