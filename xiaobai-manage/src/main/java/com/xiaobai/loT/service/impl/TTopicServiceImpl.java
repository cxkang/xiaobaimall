package com.xiaobai.loT.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.xiaobai.common.utils.R;
import com.xiaobai.loT.dao.TPaintingTopicDao;
import com.xiaobai.loT.entity.TPaintingTopicEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.Query;

import com.xiaobai.loT.dao.TTopicDao;
import com.xiaobai.loT.entity.TTopicEntity;
import com.xiaobai.loT.service.TTopicService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


@Service("tTopicService")
public class TTopicServiceImpl extends ServiceImpl<TTopicDao, TTopicEntity> implements TTopicService {

    @Resource
    private TTopicDao tTopicDao;
    @Resource
    private TPaintingTopicDao tPaintingTopicDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TTopicEntity> page = this.page(
                new Query<TTopicEntity>().getPage(params),
                new QueryWrapper<TTopicEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public TTopicEntity getByDataUuid(String dataUuid) {
        TTopicEntity tTopicEntity = tTopicDao.selectById(dataUuid);
        if(tTopicEntity==null){
            throw  new  IllegalArgumentException("没有相关记录");
        }
        return tTopicEntity;
    }

    @Override
    public R removeByDataUuids(String[] dataUuids) {
        if(dataUuids==null||dataUuids.length==0){
            return R.error("请选择");
        }
        tPaintingTopicDao.deleteObject(Arrays.asList(dataUuids));
        int rows = tTopicDao.deleteBatchByIds(dataUuids);
        if(rows==0){
            return  R.error("没有相关记录，删除失败");
        }
        return R.error("删除成功");

    }

}