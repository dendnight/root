package com.dendnight.core;

import java.io.Serializable;

/**
 * 分页
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月16日 下午3:10:24  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public abstract class Pagination implements Serializable {

	private static final long serialVersionUID = 3717895025579044361L;

	public static final String ORDER_ASC = "ASC";

	public static final String ORDER_DESC = "DESC";

	/**
	 * 默认分页大小. 无需分页时，为0时则表示无需分页。
	 */
	private int pagesize = 20;

	/**
	 * 当前页
	 */
	private int page = 1;

	/**
	 * 记录总数
	 */
	private int total;

	/**
	 * 需要排序的字段
	 */
	private String sort;

	/**
	 * 排序方式。ASC or DESC(默认)。
	 */
	private String order = ORDER_DESC;

	/**
	 * @return 从第几条记录开始显示
	 */
	public int getStart() {
		return getOffset() + 1;
	}

	/**
	 * 记录起始索引
	 * 
	 * @return
	 */
	public int getOffset() {
		return (page - 1) * pagesize;
	}

	/**
	 * @return 显示到第几条记录结束
	 */
	public int getEnd() {
		return page * pagesize;
	}

	/**
	 * @return 分页大小
	 */
	public int getPagesize() {
		return pagesize;
	}

	/**
	 * @param pagesize
	 *            分页大小
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * @return 当前页
	 */
	public int getPage() {
		if (page > getMaxPageNumber()) {
			page = getMaxPageNumber();
		}
		return page;
	}

	/**
	 * @param pageNum
	 *            当前页
	 */
	public void setPage(int pageNum) {
		this.page = pageNum;
	}

	/**
	 * @return 记录总数
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            记录总数
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return 总页数
	 */
	public int getTotalPage() {

		if (pagesize == 0) {
			return total != 0 ? 1 : 0;
		}

		if (0 == total % pagesize) {
			return total / pagesize;
		} else {
			return (total / pagesize) + 1;
		}
	}

	/**
	 * @return 需排序的字段
	 */
	public String getSort() {
		if (isSortFieldValid()) {
			return sort;
		} else {
			return getDefaultSort();
		}
	}

	/**
	 * @param sort
	 *            需排序的字段
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return 排序方式。升序或降序
	 */
	public String getOrder() {
		return "ASC".equalsIgnoreCase(order) ? "ASC" : "DESC";
	}

	/**
	 * @param order
	 *            排序方式。ASC或DESC
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return 默认排序字段
	 */
	public abstract String getDefaultSort();

	/**
	 * 返回哪些字段是可以排序的。用于过滤从客户端传递过来的非法参数。
	 * 
	 * @return 有效的排序字段
	 */
	public abstract String[] getValidSortFields();

	/**
	 * 判断字段是否可用排序。 用此可过滤从客户端传递过来的非法参数。
	 * 
	 * @return
	 */
	public boolean isSortFieldValid() {
		String[] fields = getValidSortFields();

		if (null == fields || 0 == fields.length)
			return false;

		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equalsIgnoreCase(sort)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 返回下一页页码
	 * 
	 * @return
	 */
	public int getNextPageNumber() {
		int nextPageNumber = page + 1;
		if (nextPageNumber > getMaxPageNumber()) {
			nextPageNumber = getMaxPageNumber();
		}
		return nextPageNumber;
	}

	/**
	 * 返回上一页页码
	 * 
	 * @return
	 */
	public int getPreviousPageNumber() {
		int previousPageNumber = page - 1;
		if (previousPageNumber < 1) {
			previousPageNumber = 1;
		}
		return previousPageNumber;
	}

	/**
	 * 返回最大页码编号
	 * 
	 * @return
	 */
	public int getMaxPageNumber() {
		int maxPageNumber = 1;
		if (total > pagesize) {
			if (0 == total % pagesize) {
				maxPageNumber = total / pagesize;
			} else {
				maxPageNumber = total / pagesize + 1;
			}
		}
		return maxPageNumber;
	}

	/**
	 * 用于转换非法字符
	 * 
	 * @param param
	 * @return
	 */
	// public String escape(String param) {
	// return CommonUtils.escapeJavaScript(param);
	// }
}
