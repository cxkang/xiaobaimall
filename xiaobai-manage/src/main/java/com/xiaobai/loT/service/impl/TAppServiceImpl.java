package com.xiaobai.loT.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.Query;

import com.xiaobai.loT.dao.TAppDao;
import com.xiaobai.loT.entity.TAppEntity;
import com.xiaobai.loT.service.TAppService;


@Service("tAppService")
public class TAppServiceImpl extends ServiceImpl<TAppDao, TAppEntity> implements TAppService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TAppEntity> page = this.page(
                new Query<TAppEntity>().getPage(params),
                new QueryWrapper<TAppEntity>()
        );

        return new PageUtils(page);
    }

}