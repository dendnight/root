package com.dendnight.core.service;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.PaginatedList;
import com.dendnight.core.criteria.AccessLogCriteria;
import com.dendnight.core.domain.AccessLog;

/**
 * 访问日志
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月6日 下午8:04:45  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface AccessLogService {

	/**
	 * 创建访问日志
	 * 
	 * @param info
	 * @param accessLog
	 */
	void create(LoginInfo info, AccessLog accessLog);

	/**
	 * 日志列表
	 * 
	 * @param info
	 * @param accessLogCriteria
	 * @return
	 */
	PaginatedList<AccessLog> list(LoginInfo info, AccessLogCriteria accessLogCriteria);
}
