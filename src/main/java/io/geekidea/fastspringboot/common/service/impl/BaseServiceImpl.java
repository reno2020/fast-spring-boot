package io.geekidea.fastspringboot.common.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.geekidea.fastspringboot.common.enums.OrderEnum;
import io.geekidea.fastspringboot.common.service.BaseService;
import io.geekidea.fastspringboot.common.web.vo.QueryParam;

/**
 * @author liujixiang
 * @date 2018-11-08
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    protected void setPageParam(Page page, QueryParam queryParam) {
        setPageParam(page,queryParam,null,null);
    }

    protected void setPageParam(Page page, QueryParam queryParam, String defaultOrderField, OrderEnum orderEnum) {
        page.setCurrent(queryParam.getCurrent());
        page.setSize(queryParam.getSize());
        page.setAsc(queryParam.getAscs());
        page.setDesc(queryParam.getDescs());

        if (orderEnum == OrderEnum.DESC){
            page.setDesc(defaultOrderField);
        }else {
            page.setAsc(defaultOrderField);
        }
    }

    protected void setDefaultOrder(Page page, String orderField, OrderEnum orderEnum) {
        if (orderEnum == OrderEnum.DESC){
            page.setDesc(orderField);
        }else {
            page.setAsc(orderField);
        }
    }

}
