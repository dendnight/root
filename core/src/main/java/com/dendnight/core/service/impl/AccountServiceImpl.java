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
	public int create(UserInf userInf, String password) {

		userInfMapper.insertSelective(userInf);

		AccountInf record = new AccountInf();
		record.setUserId(userInf.getId());
		record.setUsername(userInf.getMobile());

		record.setPassword(Md5Utils.getMd5ByStr(password));
		accountInfMapper.insertSelective(record);
		return userInf.getId();
	}

	@Override
	public void delete(LoginInfo info) {

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
	public AccountInf query(AccountInf accountInf) {
		return null;
	}

}
