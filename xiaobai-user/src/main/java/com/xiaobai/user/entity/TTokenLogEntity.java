package com.xiaobai.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Token日志表
 * 
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 19:32:04
 */
@Data
@TableName("t_token_log")
public class TTokenLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Integer id;
	/**
	 * $column.comments
	 */
	private String dataUuid;
	/**
	 * $column.comments
	 */
	private String userUuid;
	/**
	 * $column.comments
	 */
	private String token;
	/**
	 * $column.comments
	 */
	private String remark;
	/**
	 * $column.comments
	 */
	private Date expireTime;
	/**
	 * $column.comments
	 */
	private Date createTime;
	/**
	 * $column.comments
	 */
	private Date updateTime;

}
