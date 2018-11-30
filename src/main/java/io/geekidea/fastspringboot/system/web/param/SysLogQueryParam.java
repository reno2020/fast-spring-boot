package io.geekidea.fastspringboot.system.web.param;

import io.geekidea.fastspringboot.common.web.vo.QueryParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统日志 查询参数对象
 * </p>
 *
 * @author liujixiang
 * @date 2018-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysLogQueryParam对象", description="系统日志查询参数")
public class SysLogQueryParam extends QueryParam {
    private static final long serialVersionUID = 1L;
}
