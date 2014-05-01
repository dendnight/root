package com.dendnight.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
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
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 541470551483275591L;
	protected HttpServletRequest request;
	protected Log log = LogFactory.getLog(BaseAction.class);
	protected HttpServletResponse response;
	/** 会话 */
	protected Map<String, Object> session;

	/** 用户登录信息 */
	protected static final String LOGININFO = "loginInfo";

	/** 登录超时 */
	protected static final String TIMEOUT = "timeout";

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

	/**
	 * 登录信息
	 * 
	 * @return
	 */
	public LoginInfo info() {
		if (null == session) {
			return null;
		}

		Object info = session.get(LOGININFO);
		if (null == info) {
			return null;
		}

		return (LoginInfo) info;
	}

	/**
	 * @return the {@link #session}
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the {@link #session} to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return the {@link #json}
	 */
	public Map<String, Object> getJson() {
		return json;
	}

	/**
	 * @param json
	 *            the {@link #json} to set
	 */
	public void setJson(Map<String, Object> json) {
		this.json = json;
	}

	/**
	 * @return the {@link #timeout}
	 */
	public boolean isTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *            the {@link #timeout} to set
	 */
	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public String getSessionId() {
		return request.getSession().getId();
	}
}
