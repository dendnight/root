package com.dendnight.core.service;

import com.dendnight.common.LoginInfo;
import com.dendnight.common.PaginatedList;
import com.dendnight.core.criteria.ImageInfCriteria;
import com.dendnight.core.domain.ImageInf;

/**
 * 图片信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月6日 下午8:35:40  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public interface ImageService {

	/**
	 * 创建图片信息
	 * 
	 * @param info
	 * @param imageInf
	 */
	void create(LoginInfo info, ImageInf imageInf);

	/**
	 * 修改图片信息
	 * 
	 * @param info
	 * @param imageInf
	 */
	void update(LoginInfo info, ImageInf imageInf);

	/**
	 * 图片列表
	 * 
	 * @param info
	 * @param imageInfCriteria
	 * @return
	 */
	PaginatedList<ImageInf> list(LoginInfo info, ImageInfCriteria criteria);

	/**
	 * 删除图片
	 * 
	 * @param info
	 * @param id
	 */
	void delete(LoginInfo info, Integer id);

	/**
	 * 查询图片信息
	 * 
	 * @param info
	 * @param id
	 * @return
	 */
	ImageInf query(LoginInfo info, Integer id);

	/**
	 * 查询图片信息
	 * 
	 * @param info
	 * @param md5
	 * @return
	 */
	ImageInf query(LoginInfo info, String md5);
}
