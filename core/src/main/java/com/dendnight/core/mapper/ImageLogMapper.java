package com.dendnight.core.mapper;

import com.dendnight.core.domain.ImageLog;

public interface ImageLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImageLog record);

    int insertSelective(ImageLog record);

    ImageLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImageLog record);

    int updateByPrimaryKey(ImageLog record);
}