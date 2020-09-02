package com.xiaobai.loT.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.loT.entity.TAppEntity;

import java.util.Map;

/**
 * Android App
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
public interface TAppService extends IService<TAppEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

