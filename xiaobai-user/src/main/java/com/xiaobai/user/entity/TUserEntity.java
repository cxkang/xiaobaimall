package com.xiaobai.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户表
 * 
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 19:32:04
 */
@Data
@TableName("t_user")

public class TUserEntity implements Serializable {
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
	private String clientId;
	/**
	 * $column.comments
	 */
	private String clientPassword;
	/**
	 * $column.comments
	 */
	private String nickname;
	/**
	 * $column.comments
	 */
	private String sex;
	/**
	 * $column.comments
	 */
	private Date birthday;
	/**
	 * $column.comments
	 */
	private Date lastLogin;
	/**
	 * $column.comments
	 */
	private String lastIp;
	/**
	 * $column.comments
	 */
	private String lastDevice;
	/**
	 * $column.comments
	 */
	private String headUrl;
	/**
	 * $column.comments
	 */
	private String category;
	/**
	 * $column.comments
	 */
	private String remark;
	/**
	 * $column.comments
	 */
	private Date createTime;
	/**
	 * $column.comments
	 */
	private Date updateTime;

}
