package com.dendnight.core.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.PaginatedList;
import com.dendnight.core.criteria.UserInfCriteria;
import com.dendnight.core.domain.UserInf;
import com.dendnight.core.mapper.UserInfMapper;
import com.dendnight.core.service.UserService;

/**
 * 用户信息
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月10日 下午9:35:04  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfMapper userInfMapper;

	@Override
	public void update(LoginInfo info, UserInf userInf) {
		userInf.setDeleted(null);
		userInf.setUpdatedBy(info.getId());
		userInf.setUpdatedTime(new Date());
		userInfMapper.updateByPrimaryKeySelective(userInf);
	}

	@Override
	public UserInf query(LoginInfo info, int id) {
		UserInf userInf = userInfMapper.selectByPrimaryKey(id);
		if (null != userInf && 0 == userInf.getDeleted()) {
			return userInf;
		}
		return null;
	}

	@Override
	public PaginatedList<UserInf> list(LoginInfo info, UserInfCriteria userInfCriteria) {
		PaginatedList<UserInf> result = new PaginatedList<UserInf>();

		return result;
	}

}
