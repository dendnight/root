package com.dendnight.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.PaginatedList;
import com.dendnight.core.criteria.ImageInfCriteria;
import com.dendnight.core.domain.ImageAss;
import com.dendnight.core.domain.ImageInf;
import com.dendnight.core.domain.ImageLog;
import com.dendnight.core.mapper.ImageAssMapper;
import com.dendnight.core.mapper.ImageInfMapper;
import com.dendnight.core.mapper.ImageLogMapper;
import com.dendnight.core.service.ImageService;

/**
 * 图片信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月10日 下午11:22:27  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Service("ImageService")
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageInfMapper imageInfMapper;

	@Autowired
	private ImageAssMapper imageAssMapper;

	@Autowired
	private ImageLogMapper imageLogMapper;

	@Override
	public void create(LoginInfo info, ImageInf imageInf) {

		// 为用户绑定图片
		if (null != info) {
			ImageAss imageAss = new ImageAss();
			imageAss.setImageId(imageInf.getId());
			imageAss.setUserId(info.getId());
			imageAss.setCreatedBy(info.getId());
			imageAssMapper.insertSelective(imageAss);
		} else {// 临时用户写入日志
			ImageLog imageLog = new ImageLog();
			imageLog.setIp(info.getIp());
			imageLog.setDetails(info.getHeader());
			imageLogMapper.insertSelective(imageLog);
		}
		imageInfMapper.insertSelective(imageInf);
	}

	@Override
	public void update(LoginInfo info, ImageInf imageInf) {
		// TODO Auto-generated method stub

	}

	@Override
	public PaginatedList<ImageInf> list(LoginInfo info, ImageInfCriteria imageInfCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(LoginInfo info, String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ImageInf query(LoginInfo info, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
