package io.geekidea.fastspringboot.system.service;

import io.geekidea.fastspringboot.system.entity.SysLog;
import io.geekidea.fastspringboot.common.service.BaseService;
import io.geekidea.fastspringboot.system.web.param.SysLogQueryParam;
import io.geekidea.fastspringboot.system.web.vo.SysLogQueryVo;
import io.geekidea.fastspringboot.common.web.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author liujixiang
 * @since 2018-11-30
 */
public interface SysLogService extends BaseService<SysLog> {
    /**
     * 根据ID获取查询对象
     * @param id
     * @return
     */
    SysLogQueryVo getSysLogById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     * @param sysLogQueryParam
     * @return
     */
    Paging<SysLogQueryVo> getSysLogPageList(SysLogQueryParam sysLogQueryParam) throws Exception;

}
