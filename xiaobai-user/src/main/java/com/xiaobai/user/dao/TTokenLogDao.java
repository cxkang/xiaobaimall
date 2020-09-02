package com.xiaobai.user.dao;

import com.xiaobai.user.entity.TTokenLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Token日志表
 * 
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 19:32:04
 */
@Mapper
public interface TTokenLogDao extends BaseMapper<TTokenLogEntity> {
	
}
