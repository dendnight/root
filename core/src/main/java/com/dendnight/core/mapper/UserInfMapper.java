package com.dendnight.core.mapper;

import java.util.List;

import com.dendnight.core.criteria.UserInfCriteria;
import com.dendnight.core.domain.UserInf;

public interface UserInfMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserInf record);

	int insertSelective(UserInf record);

	UserInf selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserInf record);

	int updateByPrimaryKey(UserInf record);

	/**
	 * 数量
	 * 
	 * @param criteria
	 * @return
	 */
	int count(UserInfCriteria criteria);

	/**
	 * 列表
	 * 
	 * @param criteria
	 * @return
	 */
	List<UserInf> list(UserInfCriteria criteria);
}