package com.xiaobai.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.Query;

import com.xiaobai.user.dao.TTokenLogDao;
import com.xiaobai.user.entity.TTokenLogEntity;
import com.xiaobai.user.service.TTokenLogService;


@Service("tTokenLogService")
public class TTokenLogServiceImpl extends ServiceImpl<TTokenLogDao, TTokenLogEntity> implements TTokenLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TTokenLogEntity> page = this.page(
                new Query<TTokenLogEntity>().getPage(params),
                new QueryWrapper<TTokenLogEntity>()
        );

        return new PageUtils(page);
    }

}