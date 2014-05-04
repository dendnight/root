package com.dendnight.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dendnight.core.criteria.ImageInfCriteria;
import com.dendnight.core.domain.ImageInf;

public interface ImageInfMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(ImageInf record);

	ImageInf selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ImageInf record);

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

	/**
	 * 按md5查询
	 * 
	 * @param md5
	 * @return
	 */
	ImageInf query(@Param("md5") String md5);
}