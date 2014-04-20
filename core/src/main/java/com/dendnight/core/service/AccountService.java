package com.dendnight.core.service;

import com.dendnight.common.LoginInfo;
import com.dendnight.core.domain.AccountInf;
import com.dendnight.core.domain.UserInf;

/**
 * 帐号信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月6日 下午7:36:56  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface AccountService {

	/**
	 * 创建帐号
	 * 
	 * @param userInf
	 * @param password
	 * @throws Exception
	 */
	int signup(UserInf userInf, String password) throws Exception;

	/**
	 * 注销帐号
	 * 
	 * @param info
	 * @param id
	 * @throws Exception
	 */
	void unsubscribe(LoginInfo info);

	/**
	 * 修改帐号信息
	 * 
	 * @param info
	 * @param accountInf
	 */
	void update(LoginInfo info, AccountInf accountInf);

	/**
	 * 登录
	 * 
	 * @param accountInf
	 * @return
	 * @throws Exception
	 */
	UserInf signin(String username, String password) throws Exception;
}
