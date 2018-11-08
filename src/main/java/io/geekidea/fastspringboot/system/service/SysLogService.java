package io.geekidea.fastspringboot.system.service;

import io.geekidea.fastspringboot.system.entity.SysLog;
import io.geekidea.fastspringboot.common.service.BaseService;
import io.geekidea.fastspringboot.system.web.param.SysLogQueryParam;
import io.geekidea.fastspringboot.system.web.vo.SysLogQueryVo;
import io.geekidea.fastspringboot.common.web.vo.Paging;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author liujixiang
 * @since 2018-11-08
 */
public interface SysLogService extends BaseService<SysLog> {
    /**
     * 根据ID获取查询对象
     * @param id
     * @return
     */
    SysLogQueryVo getById(String id) throws Exception;

    /**
     * 获取分页对象
     * @param sysLogQueryParam
     * @return
     */
    Paging<SysLogQueryVo> getPageList(SysLogQueryParam sysLogQueryParam) throws Exception;

}
