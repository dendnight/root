package com.dendnight.core.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.Md5Utils;
import com.dendnight.core.domain.AccountInf;
import com.dendnight.core.domain.UserInf;
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

	@Override
	public int register(UserInf userInf, String password) {

		userInf.setCreatedBy(0);
		userInfMapper.insertSelective(userInf);

		AccountInf account = new AccountInf();
		account.setUserId(userInf.getId());
		account.setUsername(userInf.getMobile());

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
	public UserInf login(String username, String password) throws Exception {
		// 查询帐号
		password = Md5Utils.getMd5ByStr(password);
		AccountInf accountInf = accountInfMapper.login(username, password);
		if (null == accountInf || 1 == accountInf.getDeleted()) {
			throw new Exception("帐号不存在或密码错误");
		}

		// 更新登录次数和时间
		accountInf.setCount(accountInf.getCount() + 1);
		accountInf.setLastTime(new Date());
		accountInfMapper.updateByPrimaryKeySelective(accountInf);

		// 返回用户信息
		return userInfMapper.selectByPrimaryKey(accountInf.getUserId());
	}
}
