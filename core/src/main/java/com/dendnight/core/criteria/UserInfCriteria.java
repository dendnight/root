package com.dendnight.core.criteria;

import com.dendnight.common.Pagination;

/**
 * 用户查询
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月6日 下午7:49:15  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class UserInfCriteria extends Pagination {

	private static final long serialVersionUID = -1013507951510527102L;

	private Integer deleted = 0;

	@Override
	public String getDefaultSort() {
		return "user_inf_created_time";
	}

	@Override
	public String[] getValidSortFields() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the {@link #deleted}
	 */
	public Integer getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the {@link #deleted} to set
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}
