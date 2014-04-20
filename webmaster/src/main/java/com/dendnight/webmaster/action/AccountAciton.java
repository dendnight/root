package com.dendnight.webmaster.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.common.BaseAction;
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
 * Create at:	2014年4月20日 下午9:31:49  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("AccountAciton")
@Scope("prototype")
public class AccountAciton extends BaseAction {

	private static final long serialVersionUID = 7375538097241008562L;

	/** 帐号 */
	private String username;

	/** 密码 */
	private String password;

	@Autowired
	private AccountService accountService;

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String signin() {
		try {
			accountService.signin(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
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

}
