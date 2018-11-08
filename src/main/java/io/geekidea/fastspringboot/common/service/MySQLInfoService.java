package io.geekidea.fastspringboot.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.geekidea.fastspringboot.common.entity.MySQLInfo;

/**
 * <p>
 * MySQL信息查询 服务类
 * </p>
 *
 * @author liujixiang
 * @date 2018-11-08
 */
public interface MySQLInfoService extends IService<MySQLInfo> {

    String getVersion();

}
