package io.geekidea.fastspringboot.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.geekidea.fastspringboot.system.entity.SysLog;
import io.geekidea.fastspringboot.system.mapper.SysLogMapper;
import io.geekidea.fastspringboot.system.service.SysLogService;
import io.geekidea.fastspringboot.system.web.param.SysLogQueryParam;
import io.geekidea.fastspringboot.system.web.vo.SysLogQueryVo;
import io.geekidea.fastspringboot.common.enums.OrderEnum;
import io.geekidea.fastspringboot.common.web.vo.Paging;
import io.geekidea.fastspringboot.common.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author liujixiang
 * @since 2018-11-30
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysLogQueryVo getSysLogById(Serializable id) throws Exception{
        return sysLogMapper.getSysLogById(id);
    }

    @Override
    public Paging<SysLogQueryVo> getSysLogPageList(SysLogQueryParam sysLogQueryParam) throws Exception{
        Page page = setPageParam(sysLogQueryParam,"create_time", OrderEnum.DESC);
        IPage<SysLogQueryVo> iPage = sysLogMapper.getSysLogPageList(page,sysLogQueryParam);
        return new Paging(iPage);
    }

}
