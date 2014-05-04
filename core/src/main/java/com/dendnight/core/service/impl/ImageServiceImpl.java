package com.dendnight.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.common.LoginInfo;
import com.dendnight.common.PaginatedList;
import com.dendnight.core.criteria.ImageInfCriteria;
import com.dendnight.core.domain.ImageAss;
import com.dendnight.core.domain.ImageInf;
import com.dendnight.core.mapper.ImageAssMapper;
import com.dendnight.core.mapper.ImageInfMapper;
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

	@Override
	public void create(LoginInfo info, ImageInf imageInf) {

		// 为用户绑定图片
		if (null != info) {
			ImageAss imageAss = new ImageAss();
			imageAss.setImageId(imageInf.getId());
			imageAss.setUserId(info.getId());
			imageAss.setCreatedBy(info.getId());
			imageAss.setImageName(imageInf.getName());
			imageAssMapper.insertSelective(imageAss);
		}
		imageInfMapper.insertSelective(imageInf);
	}

	@Override
	public void update(LoginInfo info, ImageInf imageInf) {
		// 为用户绑定图片
		if (null != info) {
			ImageAss imageAss = new ImageAss();
			imageAss.setImageId(imageInf.getId());
			imageAss.setUserId(info.getId());
			imageAss.setCreatedBy(info.getId());
			imageAss.setImageName(imageInf.getName());
			imageAssMapper.insertSelective(imageAss);
		}

		imageInf.setDeleted(null);
		imageInf.setUpdatedBy(0);
		imageInf.setUpdatedTime(new Date());
		imageInfMapper.updateByPrimaryKeySelective(imageInf);
	}

	@Override
	public PaginatedList<ImageInf> list(LoginInfo info, ImageInfCriteria criteria) {
		PaginatedList<ImageInf> result = new PaginatedList<ImageInf>();
		List<ImageInf> list = new ArrayList<ImageInf>();

		if (0 != criteria.getPagesize()) {
			int total = imageInfMapper.count(criteria);
			criteria.setTotal(total);
			if (0 < total) {
				list = imageInfMapper.list(criteria);
			}
		} else {
			list = imageInfMapper.list(criteria);
		}

		result.setList(list);
		result.setPagination(criteria);
		return result;
	}

	@Override
	public ImageInf query(LoginInfo info, String md5) {
		return imageInfMapper.query(md5);
	}

	@Override
	public void delete(LoginInfo info, Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ImageInf query(LoginInfo info, Integer id) {
		return imageInfMapper.selectByPrimaryKey(id);
	}

}
