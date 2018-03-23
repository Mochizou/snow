package com.weknow.wh.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weknow.wh.dao.TargetWebMapper;
import com.weknow.wh.model.TargetWeb;
import com.weknow.wh.service.TargetWebServicesI;

@Service("targetWebServices")
public class TargetWebServicesImpl implements TargetWebServicesI{
	
	@Autowired
	private TargetWebMapper targetWebMapper;

	@Override
	public int insert(TargetWeb record) {
		
		targetWebMapper.insert(record);
		return 0;
	}

	

}
