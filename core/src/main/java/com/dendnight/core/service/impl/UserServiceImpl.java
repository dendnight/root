package com.dendnight.core.service.impl;

import org.springframework.stereotype.Service;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.PaginatedList;
import com.dendnight.core.criteria.UserInfCriteria;
import com.dendnight.core.domain.UserInf;
import com.dendnight.core.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Override
	public void update(LoginInfo info, UserInf userInf) {
		// TODO Auto-generated method stub

	}

	@Override
	public PaginatedList<UserInf> list(LoginInfo info, UserInfCriteria userInfCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
