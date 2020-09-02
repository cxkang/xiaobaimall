package com.xiaobai.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.R;
import com.xiaobai.user.entity.TUserEntity;

import java.util.Map;

/**
 * 用户表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 19:32:04
 */
public interface TUserService extends IService<TUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R queryUser(String username, String password);
}

