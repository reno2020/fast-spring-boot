package io.geekidea.fastspringboot.common.api;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

/**
 * <p>
 * REST API 响应码
 * </p>
 *
 * @author liujixiang
 * @since 2018-11-08
 */
public enum ApiCode implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 失败
     */
    FAILED(500, "操作失败"),

    /**
     * 你请求的路径不存在
     */
    NOT_FOUND(404, "你请求的路径不存在"),

    /**
     * 请求参数校验异常
     */
    PARAMETER_EXCEPTION(5001,"请求参数校验异常"),

    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(5000,"系统异常!"),

    /**
     * 请求参数解析异常
     */
    PARAMETER_PARSE_EXCEPTION(5002,"请求参数解析异常"),

    /**
     * HTTP Media 类型异常
     */
    HTTP_MEDIA_TYPE_EXCEPTION(5003,"HTTP Media 类型异常")

    ;


    private final long code;
    private final String msg;

    ApiCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiCode fromCode(long code) {
        ApiCode[] ecs = ApiCode.values();
        for (ApiCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return String.format(" ErrorCode:{code=%s, msg=%s} ", code, msg);
    }
}
