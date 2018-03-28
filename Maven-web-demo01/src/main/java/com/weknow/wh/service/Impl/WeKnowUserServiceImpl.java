package com.weknow.wh.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weknow.wh.dao.WeKnowUserMapper;
import com.weknow.wh.model.WeKnowUser;
import com.weknow.wh.service.WeKnowUserServiceI;

@Service("weKnowUserService")
public class WeKnowUserServiceImpl implements WeKnowUserServiceI{
	
	
	@Autowired
	private WeKnowUserMapper weKnowUserMapper;

	@Override
	public int insert(WeKnowUser record) {
		int ins = 0;
		ins = weKnowUserMapper.insert(record);
		
		return ins;
	}

	@Override
	public int insertSelective(WeKnowUser record) {
		
		int ins = weKnowUserMapper.insertSelective(record);
		return ins;
	}
	

}
