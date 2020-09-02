package com.xiaobai.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.user.entity.TTokenLogEntity;

import java.util.Map;

/**
 * Token日志表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 19:32:04
 */
public interface TTokenLogService extends IService<TTokenLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

