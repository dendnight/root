package com.dendnight.website.action;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.core.BaseAction;
import com.dendnight.core.domain.UserInf;
import com.dendnight.core.service.AccountService;

/**
 * 帐号信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月12日 上午12:42:16  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("AccountAction")
@Scope("prototype")
public class AccountAction extends BaseAction {

	private static final long serialVersionUID = 5173101529923734223L;

	@Autowired
	private AccountService accountService;

	/** 帐号 */
	private String username;

	/** 密码 */
	private String password;

	private UserInf user;

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		json = new HashMap<String, Object>();
		if (StringUtils.isBlank(username)) {
			json.put(S, 0);
			json.put(M, "帐号不能为空");
			return JSON;
		}

		if (StringUtils.isBlank(password)) {
			json.put(S, 0);
			json.put(M, "密码不能为空");
			return JSON;
		}

		try {
			accountService.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.warn(e.getMessage(), e);
			json.put(S, 0);
			json.put(M, e.getMessage());
		}
		return JSON;
	}

	public String register() {
		try {
			accountService.register(user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSON;
	}

	/**
	 * @return the {@link #username}
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the {@link #username} to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the {@link #password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the {@link #password} to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the {@link #user}
	 */
	public UserInf getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the {@link #user} to set
	 */
	public void setUser(UserInf user) {
		this.user = user;
	}

}
