package com.dendnight.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.dendnight.core.domain.AccountInf;

public interface AccountInfMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(AccountInf record);

	int insertSelective(AccountInf record);

	AccountInf selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(AccountInf record);

	int updateByPrimaryKey(AccountInf record);

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	AccountInf login(@Param("username") String username, @Param("password") String password);
}