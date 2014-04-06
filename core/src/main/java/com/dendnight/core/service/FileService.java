package com.dendnight.core.service;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.domain.FileInf;

/**
 * 文件信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月6日 下午9:09:51  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface FileService {

	/**
	 * 创建文件信息
	 * 
	 * @param info
	 * @param fileInf
	 */
	void create(LoginInfo info, FileInf fileInf);
}
