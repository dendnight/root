package com.dendnight.core.service;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.PaginatedList;
import com.dendnight.core.criteria.UserInfCriteria;
import com.dendnight.core.domain.UserInf;

/**
 * 用户信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月6日 下午7:25:38  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface UserService {

	/**
	 * 修改用户信息
	 * 
	 * @param info
	 * @param userInf
	 */
	void update(LoginInfo info, UserInf userInf);

	/**
	 * 用户列表
	 * 
	 * @param info
	 * @param userInfCriteria
	 * @return
	 */
	PaginatedList<UserInf> list(LoginInfo info, UserInfCriteria userInfCriteria);
}
