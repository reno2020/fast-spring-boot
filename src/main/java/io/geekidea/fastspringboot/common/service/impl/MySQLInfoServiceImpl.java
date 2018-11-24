package io.geekidea.fastspringboot.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.geekidea.fastspringboot.common.entity.MySQLInfo;
import io.geekidea.fastspringboot.common.mapper.MySQLInfoMapper;
import io.geekidea.fastspringboot.common.service.MySQLInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * MySQL信息查询 服务实现类
 * </p>
 *
 * @author liujixiang
 * @date 2018-11-08
 */
@Service
@Transactional
@Slf4j
public class MySQLInfoServiceImpl extends ServiceImpl<MySQLInfoMapper, MySQLInfo> implements MySQLInfoService {

    @Autowired
    private MySQLInfoMapper mySQLInfoMapper;

    @Override
    public String getVersion() {
        return mySQLInfoMapper.getVersion();
    }
}
