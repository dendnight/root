package com.dendnight.core.service;

import com.dendnight.common.LoginInfo;
import com.dendnight.common.PaginatedList;
import com.dendnight.core.criteria.ParamSysCriteria;
import com.dendnight.core.domain.ParamSys;

/**
 * 系统参数接口
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月20日 下午8:52:01  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface ParamSysService {

	/**
	 * 创建系统参数
	 * 
	 * @param info
	 * @param paramSys
	 * @return
	 */
	int create(LoginInfo info, ParamSys paramSys);

	/**
	 * 修改系统参数
	 * 
	 * @param info
	 * @param paramSys
	 */
	void update(LoginInfo info, ParamSys paramSys);

	/**
	 * 系统参数列表
	 * 
	 * @param info
	 * @param criteria
	 * @return
	 */
	public PaginatedList<ParamSys> list(LoginInfo info, ParamSysCriteria criteria);

	/**
	 * 删除
	 * 
	 * @param info
	 * @param id
	 */
	void delete(LoginInfo info, int id);

	/**
	 * 查询
	 * 
	 * @param info
	 * @param id
	 * @return
	 */
	ParamSys query(LoginInfo info, int id);

}
