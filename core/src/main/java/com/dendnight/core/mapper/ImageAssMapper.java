package com.dendnight.core.mapper;

import com.dendnight.core.domain.ImageAss;

public interface ImageAssMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ImageAss record);

    ImageAss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImageAss record);

    int updateByPrimaryKey(ImageAss record);
}