package com.dendnight.core.mapper;

import com.dendnight.core.domain.AccountInf;

public interface AccountInfMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(AccountInf record);

    int insertSelective(AccountInf record);

    AccountInf selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(AccountInf record);

    int updateByPrimaryKey(AccountInf record);
}