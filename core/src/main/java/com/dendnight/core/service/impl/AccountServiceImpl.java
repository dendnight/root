package com.dendnight.core.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.common.LoginInfo;
import com.dendnight.common.Md5Utils;
import com.dendnight.core.domain.AccessLog;
import com.dendnight.core.domain.AccountInf;
import com.dendnight.core.domain.UserInf;
import com.dendnight.core.mapper.AccessLogMapper;
import com.dendnight.core.mapper.AccountInfMapper;
import com.dendnight.core.mapper.UserInfMapper;
import com.dendnight.core.service.AccountService;

/**
 * 帐号信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月10日 下午9:18:45  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Service("AccountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountInfMapper accountInfMapper;

	@Autowired
	private UserInfMapper userInfMapper;

	@Autowired
	private AccessLogMapper accessLogMapper;

	@Override
	public int signup(UserInf userInf, String password) throws Exception {

		userInf.setUserType("V");
		userInf.setCreatedBy(0);
		userInfMapper.insertSelective(userInf);

		AccountInf account = new AccountInf();
		account.setUserId(userInf.getId());
		account.setUsername(userInf.getName());

		account.setPassword(Md5Utils.getMd5ByStr(password));
		account.setCreatedBy(0);
		accountInfMapper.insertSelective(account);
		return userInf.getId();
	}

	@Override
	public void unsubscribe(LoginInfo info) {

		// 设置用户信息为已删除
		UserInf userInf = new UserInf();
		userInf.setId(info.getId());
		userInf.setDeleted((byte) 1);
		userInf.setUpdatedBy(info.getId());
		userInf.setUpdatedTime(new Date());
		userInfMapper.updateByPrimaryKeySelective(userInf);

		// 设置登录帐号为已删除
		AccountInf accountInf = new AccountInf();
		accountInf.setUpdatedBy(info.getId());
		accountInf.setUpdatedTime(new Date());
		accountInf.setDeleted((byte) 1);
		accountInfMapper.updateByPrimaryKeySelective(accountInf);

	}

	@Override
	public void update(LoginInfo info, AccountInf accountInf) {

		if (StringUtils.isNotBlank(accountInf.getPassword())) {
			accountInf.setPassword(Md5Utils.getMd5ByStr(accountInf.getPassword()));
		}

		accountInf.setDeleted(null);
		accountInf.setUpdatedBy(info.getId());
		accountInf.setUpdatedTime(new Date());
		accountInfMapper.updateByPrimaryKeySelective(accountInf);
	}

	@Override
	public UserInf signin(String username, String password) throws Exception {
		// 查询帐号
		password = Md5Utils.getMd5ByStr(password);
		AccountInf account = accountInfMapper.login(username, password);
		if (null == account || 1 == account.getDeleted()) {
			throw new Exception("帐号不存在或密码错误");
		}
		int userId = account.getUserId();
		// 更新登录次数和时间
		account.setCount(account.getCount() + 1);
		account.setLastTime(new Date());
		accountInfMapper.updateByPrimaryKeySelective(account);

		// 记录访问信息
		AccessLog access = new AccessLog();
		access.setUserId(userId);
		access.setDetails("用户登录");
		accessLogMapper.insertSelective(access);

		// 返回用户信息
		return userInfMapper.selectByPrimaryKey(userId);
	}
}
