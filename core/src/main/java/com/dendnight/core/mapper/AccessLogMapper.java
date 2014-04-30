package com.dendnight.core.mapper;

import com.dendnight.core.domain.AccessLog;

public interface AccessLogMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(AccessLog record);

	AccessLog selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AccessLog record);

	int updateByPrimaryKey(AccessLog record);
}