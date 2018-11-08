package io.geekidea.fastspringboot.system.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志 查询结果对象
 * </p>
 *
 * @author liujixiang
 * @date 2018-11-08
 */
@Data
@ApiModel(value="SysLogQueryVo对象", description="系统日志查询参数")
public class SysLogQueryVo implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long logId;

    @ApiModelProperty(value = "类型")
    private Boolean type;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "创建人ID")
    private Long createId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}