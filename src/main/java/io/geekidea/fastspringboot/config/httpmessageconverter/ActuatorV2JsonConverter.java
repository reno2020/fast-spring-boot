package io.geekidea.fastspringboot.config.httpmessageconverter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
@Slf4j
public class ActuatorV2JsonConverter extends AbstractHttpMessageConverter<Object> {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private static final MediaType MEDIA_TYPE = new MediaType("application","vnd.spring-boot.actuator.v2+json");

    public ActuatorV2JsonConverter(){
        super(DEFAULT_CHARSET, MEDIA_TYPE);
    }


    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        log.debug("readInternal..........");
        return null;
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        ByteArrayOutputStream outnew = new ByteArrayOutputStream();
        JSON.writeJSONString(outnew,DEFAULT_CHARSET,obj);
        OutputStream out = outputMessage.getBody();
        outnew.writeTo(out);
        outnew.close();
    }
}
