package com.dendnight.webmaster.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.common.BaseAction;
import com.dendnight.common.PaginatedList;
import com.dendnight.core.criteria.ParamSysCriteria;
import com.dendnight.core.domain.ParamSys;
import com.dendnight.core.service.ParamSysService;

/**
 * 系统参数
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月20日 下午10:17:14  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("ParamSysAction")
@Scope("prototype")
public class ParamSysAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ParamSysService paramSysService;

	/** 参数编号 */
	private Integer id;

	/** 参数信息 */
	private ParamSys param;

	/** 参数列表 */
	private PaginatedList<ParamSys> list;

	/** 过滤信息 */
	private ParamSysCriteria criteria;

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String list() {
		return SUCCESS;
	}

	/**
	 * 创建
	 * 
	 * @return
	 */
	public String create() {
		if (null == param) {
			return INPUT;
		}
		paramSysService.create(info(), param);
		return SUCCESS;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String update() {
		return SUCCESS;
	}

	/**
	 * 查询详情
	 * 
	 * @return
	 */
	public String query() {
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		return SUCCESS;
	}

	/**
	 * @return the {@link #id}
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the {@link #id} to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the {@link #param}
	 */
	public ParamSys getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the {@link #param} to set
	 */
	public void setParam(ParamSys param) {
		this.param = param;
	}

	/**
	 * @return the {@link #list}
	 */
	public PaginatedList<ParamSys> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the {@link #list} to set
	 */
	public void setList(PaginatedList<ParamSys> list) {
		this.list = list;
	}

	/**
	 * @return the {@link #criteria}
	 */
	public ParamSysCriteria getCriteria() {
		return criteria;
	}

	/**
	 * @param criteria
	 *            the {@link #criteria} to set
	 */
	public void setCriteria(ParamSysCriteria criteria) {
		this.criteria = criteria;
	}

}
