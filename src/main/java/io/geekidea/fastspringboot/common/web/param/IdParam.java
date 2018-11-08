package io.geekidea.fastspringboot.common.web.param;

import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
@ApiModel("ID参数")
public class IdParam implements Serializable {
    private static final long serialVersionUID = -5353973980674510450L;
    
    @NotBlank(message="ID不能为空")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdParam{" +
                "id='" + id + '\'' +
                '}';
    }
}
