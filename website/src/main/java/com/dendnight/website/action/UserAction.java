package com.dendnight.website.action;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.core.BaseAction;
import com.dendnight.core.service.UserService;

/**
 * 用户信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月18日 下午9:44:38  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("UserAction")
@Scope("prototype")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 2947742528007149564L;

	Logger log = Logger.getLogger(UserAction.class);

	@Autowired
	private UserService userService;

	/** 昵称 */
	private String nickname;

	/** 帐号 */
	private String username;

	/** 类型 */
	private String usertype;

	/** 密码 */
	private String password;

	/**
	 * 登录验证
	 * 
	 * @return
	 */
	public String login() {

		json = new HashMap<String, Object>();

		if (StringUtils.isBlank(username)) {
			json.put(M, "帐号不能为空");
			json.put(S, 0);
			return JSON;
		}

		if (StringUtils.isBlank(password)) {
			json.put(M, "密码不能为空");
			json.put(S, 0);
			return JSON;
		}

		// LoginInfo info = new LoginInfo();
		// info.setId(list.getResult().get(0).getId());
		// info.setNickname(list.getResult().get(0).getNickname());
		//
		// info.setUsername(username);
		// info.setUsertype(list.getResult().get(0).getUserType());
		// session.put(LOGININFO, info);
		//
		// json.put(S, 1);
		// json.put(O, info.getNickname());
		// json.put(M, "登录成功");

		return JSON;
	}

	public String logout() {
		json = new HashMap<String, Object>();
		session.put(LOGININFO, null);
		json.put(S, 1);

		json.put(M, "已退出");
		return JSON;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}