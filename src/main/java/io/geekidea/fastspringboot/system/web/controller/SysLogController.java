package io.geekidea.fastspringboot.system.web.controller;

import io.geekidea.fastspringboot.system.entity.SysLog;
import io.geekidea.fastspringboot.system.service.SysLogService;
import io.geekidea.fastspringboot.system.web.param.SysLogQueryParam;
import io.geekidea.fastspringboot.system.web.vo.SysLogQueryVo;
import io.geekidea.fastspringboot.common.web.controller.BaseController;
import io.geekidea.fastspringboot.common.api.ApiResult;
import io.geekidea.fastspringboot.common.web.param.IdParam;
import io.geekidea.fastspringboot.common.web.vo.Paging;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @author liujixiang
 * @since 2018-11-30
 */
@RestController
@RequestMapping("/sysLog")
@Slf4j
@Api("系统日志 API")
public class SysLogController extends BaseController {

    @Autowired
    private SysLogService sysLogService;

    /**
    * 添加系统日志
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加SysLog对象",notes = "添加系统日志",response = ApiResult.class)
    public ApiResult<Boolean> addSysUser(@Valid @RequestBody SysLog sysLog) throws Exception{
        boolean flag = sysLogService.save(sysLog);
        return success(flag);
    }

    /**
    * 修改系统日志
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改SysLog对象",notes = "修改系统日志",response = ApiResult.class)
    public ApiResult<Boolean> updateSysUser(@Valid @RequestBody SysLog sysLog) throws Exception{
        boolean flag = sysLogService.updateById(sysLog);
        return success(flag);
    }

    /**
    * 删除系统日志
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除SysLog对象",notes = "删除系统日志",response = ApiResult.class)
    public ApiResult<Boolean> deleteSysUser(@Valid @RequestBody IdParam idParam) throws Exception{
        boolean flag = sysLogService.removeById(idParam.getId());
        return success(flag);
    }

    /**
    * 获取系统日志
    */
    @PostMapping("/info")
    @ApiOperation(value = "获取SysLog对象详情",notes = "查看系统日志",response = SysLogQueryVo.class)
    public ApiResult<SysLogQueryVo> getSysUser(@Valid @RequestBody IdParam idParam) throws Exception{
        SysLogQueryVo sysLogQueryVo = sysLogService.getSysLogById(idParam.getId());
        return success(sysLogQueryVo);
    }

    /**
     * 系统日志分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取SysLog分页列表",notes = "系统日志分页列表",response = SysLogQueryVo.class)
    public ApiResult<Paging<SysLogQueryVo>> getSysLogPageList(@Valid @RequestBody(required = false) SysLogQueryParam sysLogQueryParam) throws Exception{
        Paging<SysLogQueryVo> paging = sysLogService.getSysLogPageList(sysLogQueryParam);
        return success(paging);
    }

}

