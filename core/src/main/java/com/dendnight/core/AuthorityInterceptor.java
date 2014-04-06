package com.dendnight.core;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录拦截器
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2013-12-11 下午2:02:15  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -8134079860584168173L;

	@SuppressWarnings("static-access")
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();

		BaseAction action = (BaseAction) invocation.getAction();
		LoginInfo info = (LoginInfo) session.get(action.LOGININFO);

		if (info == null && isAjaxRequest(request)) {
			action.setTimeout(true);
		} else if (info == null) {
			return action.TIMEOUT;
		}
		return invocation.invoke();
	}

	private boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header)) {
			return true;
		} else {
			return false;
		}
	}
}
