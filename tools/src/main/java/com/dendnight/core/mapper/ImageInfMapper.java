package com.dendnight.core.mapper;

import com.dendnight.core.domain.ImageInf;

public interface ImageInfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImageInf record);

    int insertSelective(ImageInf record);

    ImageInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImageInf record);

    int updateByPrimaryKey(ImageInf record);
}