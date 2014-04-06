package com.dendnight.core;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2013年11月28日 上午12:21:51  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class BaseAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 541470551483275591L;

	/** 会话 */
	protected Map<String, Object> session;

	/** 用户登录信息 */
	protected static final String LOGININFO = "loginInfo";

	/** 登录超时 */
	protected static final String TIMEOUT = "timeout";

	/** 正确页面 */
	protected static final String SUCCESS = "success";

	/** 错误页面 */
	protected static final String ERROR = "error";

	/** 返回JSON */
	protected static final String JSON = "json";

	/** JSON消息 */
	protected static final String M = "m";

	/** JSON对象 */
	protected static final String O = "o";

	/** JSON状态 1成功0失败 */
	protected static final String S = "s";

	/** JSON会话超时 */
	protected static final String T = "t";

	/** JSON */
	protected Map<String, Object> json;

	/** 是否超时 */
	protected boolean timeout = false;

	public Map<String, Object> getJson() {
		return json;
	}

	public void setJson(Map<String, Object> json) {
		this.json = json;
	}

	/**
	 * 登录信息
	 * 
	 * @return
	 */
	public LoginInfo info() {
		return (LoginInfo) session.get(LOGININFO);
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public boolean isTimeout() {
		return timeout;
	}

	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}

}
