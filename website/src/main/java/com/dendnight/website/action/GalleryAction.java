package com.dendnight.website.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.common.BaseAction;
import com.dendnight.core.criteria.ImageInfCriteria;
import com.dendnight.core.service.ImageService;

/**
 * 图库信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年2月20日 下午9:29:05  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("GalleryAction")
@Scope("prototype")
public class GalleryAction extends BaseAction {

	private static final long serialVersionUID = 7099263402897874899L;

	@Autowired
	private ImageService imageService;

	/** 页码 */
	private Integer page = 1;

	private ImageInfCriteria criteria;

	public String list() {
		imageService.list(info(), criteria);

		return JSON;
	}

	/**
	 * @return the {@link #page}
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the {@link #page} to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the {@link #criteria}
	 */
	public ImageInfCriteria getCriteria() {
		return criteria;
	}

	/**
	 * @param criteria
	 *            the {@link #criteria} to set
	 */
	public void setCriteria(ImageInfCriteria criteria) {
		this.criteria = criteria;
	}

}
