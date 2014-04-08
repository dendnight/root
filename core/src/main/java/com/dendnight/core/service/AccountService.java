package com.dendnight.core.service;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.domain.AccountInf;
import com.dendnight.core.domain.UserInf;

/**
 * 帐号管理
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
	 * @param info
	 * @param userInf
	 */
	void create(LoginInfo info, UserInf userInf);

	/**
	 * 注销帐号
	 * 
	 * @param info
	 * @param id
	 */
	void delete(LoginInfo info, int id);

	/**
	 * 修改帐号信息
	 * 
	 * @param info
	 * @param accountInf
	 */
	void update(LoginInfo info, AccountInf accountInf);

	/**
	 * 查询帐号
	 * 
	 * @param accountInf
	 * @return
	 */
	UserInf query(AccountInf accountInf);
}
