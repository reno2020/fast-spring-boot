package io.geekidea.fastspringboot.common.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * 业务异常
 * @author liujixiang
 * @date 2018-11-08
 */
public class BusinessException extends RuntimeException{
    private Integer code;
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code ,String message){
        this(StringUtils.isBlank(message)?String.valueOf(code):message);
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
