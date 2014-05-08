package com.dendnight.website.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.common.BaseAction;
import com.dendnight.common.PaginatedList;
import com.dendnight.core.criteria.ImageInfCriteria;
import com.dendnight.core.domain.ImageInf;
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

	private PaginatedList<ImageInf> result;

	public String list() {
		json = new HashMap<String, Object>();
		if (timeout) {
			json.put(T, 1);
			return JSON;
		}

		List<Map<String, Object>> obj = new ArrayList<Map<String, Object>>();

		ImageInfCriteria criteria = new ImageInfCriteria();
		criteria.setPage(page);
		result = imageService.list(info(), criteria);
		if (null != result && null != result.getList() && 0 < result.getList().size()) {
			Map<String, Object> map = null;
			for (ImageInf image : result.getList()) {
				map = new HashMap<String, Object>();
				map.put("original", image.getOriginal());
				map.put("thumbnail", image.getThumbnail());
				map.put("width", image.getWidth());
				map.put("height", image.getHeight());
				obj.add(map);
			}
			map = new HashMap<String, Object>();
			map.put("totalPage", result.getPagination().getTotalPage());
			obj.add(map);
		}
		json.put(O, obj);
		return JSON;
	}

	public String execute() {
		ImageInfCriteria criteria = new ImageInfCriteria();
		result = imageService.list(info(), criteria);
		return SUCCESS;
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
	 * @return the {@link #result}
	 */
	public PaginatedList<ImageInf> getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the {@link #result} to set
	 */
	public void setResult(PaginatedList<ImageInf> result) {
		this.result = result;
	}

}
