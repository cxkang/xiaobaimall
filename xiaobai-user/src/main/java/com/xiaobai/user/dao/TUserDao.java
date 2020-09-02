package com.xiaobai.user.dao;

import com.xiaobai.user.entity.TUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表
 * 
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 19:32:04
 */
@Mapper
public interface TUserDao extends BaseMapper<TUserEntity> {


}
