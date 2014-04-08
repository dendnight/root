package com.dendnight.core.mapper;

import com.dendnight.core.domain.ParamSys;

public interface ParamSysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParamSys record);

    int insertSelective(ParamSys record);

    ParamSys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParamSys record);

    int updateByPrimaryKey(ParamSys record);
}