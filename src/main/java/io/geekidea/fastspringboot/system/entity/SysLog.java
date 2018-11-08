package io.geekidea.fastspringboot.system.entity;

import io.geekidea.fastspringboot.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统日志
 * </p>
 *
 * @author liujixiang
 * @since 2018-11-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysLog对象", description="系统日志")
public class SysLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "log_id", type = IdType.ID_WORKER)
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
