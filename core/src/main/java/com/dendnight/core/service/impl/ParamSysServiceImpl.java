package com.dendnight.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dendnight.common.LoginInfo;
import com.dendnight.common.PaginatedList;
import com.dendnight.core.criteria.ParamSysCriteria;
import com.dendnight.core.domain.ParamSys;
import com.dendnight.core.mapper.ParamSysMapper;
import com.dendnight.core.service.ParamSysService;

/**
 * 系统参数实现
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年4月20日 下午9:10:46  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Service("ParamSysService")
public class ParamSysServiceImpl implements ParamSysService {

	@Autowired
	private ParamSysMapper paramSysMapper;

	@Override
	public int create(LoginInfo info, ParamSys paramSys) {
		paramSys.setCreatedBy(info.getId());
		paramSysMapper.insertSelective(paramSys);
		return paramSys.getId();
	}

	@Override
	public void update(LoginInfo info, ParamSys paramSys) {
		paramSys.setUpdatedBy(info.getId());
		paramSys.setUpdatedTime(new Date());
		paramSysMapper.updateByPrimaryKeySelective(paramSys);
	}

	@Override
	public PaginatedList<ParamSys> list(LoginInfo info, ParamSysCriteria criteria) {
		PaginatedList<ParamSys> result = new PaginatedList<ParamSys>();
		List<ParamSys> list = new ArrayList<ParamSys>();

		if (0 != criteria.getPagesize()) {
			int total = paramSysMapper.count(criteria);
			criteria.setTotal(total);
			if (0 < total) {
				list = paramSysMapper.list(criteria);
			}
		} else {
			list = paramSysMapper.list(criteria);
		}

		result.setList(list);
		result.setPagination(criteria);
		return result;
	}

	@Override
	public void delete(LoginInfo info, int id) {
		ParamSys paramSys = query(info, id);
		if (null != paramSys) {
			paramSys.setDeleted((byte) 1);
			paramSys.setUpdatedBy(info.getId());
			paramSys.setUpdatedTime(new Date());
			paramSysMapper.updateByPrimaryKey(paramSys);
		}

	}

	@Override
	public ParamSys query(LoginInfo info, int id) {
		ParamSys paramSys = paramSysMapper.selectByPrimaryKey(id);
		if (null != paramSys && 0 != paramSys.getDeleted()) {
			return paramSys;
		}
		return null;
	}

	@Override
	public ParamSys query(LoginInfo info, String code) {
		ParamSys paramSys = paramSysMapper.selectByCode(code);
		if (null != paramSys && 0 != paramSys.getDeleted()) {
			return paramSys;
		}
		return null;
	}
}
