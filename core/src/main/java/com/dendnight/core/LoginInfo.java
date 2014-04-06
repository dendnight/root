package com.dendnight.core;

import java.io.Serializable;

/**
 * 登录信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2013年12月1日 下午3:01:56  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class LoginInfo implements Serializable {

	private static final long serialVersionUID = 8260155319208940218L;

	/** 编号 */
	private Integer id;

	/** 昵称 */
	private String nickname;

	/** 帐号 */
	private String username;

	/** 类型 */
	private String usertype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", nickname=" + nickname + ", username=" + username + ", usertype=" + usertype
				+ "]";
	}

}
