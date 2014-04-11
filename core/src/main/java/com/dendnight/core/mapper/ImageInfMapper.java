package com.dendnight.core.mapper;

import java.util.List;

import com.dendnight.core.criteria.ImageInfCriteria;
import com.dendnight.core.domain.ImageInf;

public interface ImageInfMapper {
	int deleteByPrimaryKey(String id);

	int insert(ImageInf record);

	int insertSelective(ImageInf record);

	ImageInf selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(ImageInf record);

	int updateByPrimaryKey(ImageInf record);

	/**
	 * 数量
	 * 
	 * @param criteria
	 * @return
	 */
	int count(ImageInfCriteria criteria);

	/**
	 * 列表
	 * 
	 * @param criteria
	 * @return
	 */
	List<ImageInf> list(ImageInfCriteria criteria);
}