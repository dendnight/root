package com.dendnight.core.mapper;

import java.util.List;

import com.dendnight.core.criteria.ParamSysCriteria;
import com.dendnight.core.domain.ParamSys;

public interface ParamSysMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(ParamSys record);

	ParamSys selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ParamSys record);

	int updateByPrimaryKey(ParamSys record);

	/**
	 * 数量
	 * 
	 * @param criteria
	 * @return
	 */
	int count(ParamSysCriteria criteria);

	/**
	 * 列表
	 * 
	 * @param criteria
	 * @return
	 */
	List<ParamSys> list(ParamSysCriteria criteria);
}