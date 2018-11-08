package io.geekidea.fastspringboot.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.geekidea.fastspringboot.common.entity.MySQLInfo;
import org.springframework.stereotype.Repository;

/**
 * <p>
  * MySQL信息查询 Mapper 接口
 * </p>
 *
 * @author liujixiang
 * @date 2018-11-08
 */
@Repository
public interface MySQLInfoMapper extends BaseMapper<MySQLInfo> {

    String getVersion();

}