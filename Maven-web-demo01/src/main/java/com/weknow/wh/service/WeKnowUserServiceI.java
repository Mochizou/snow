package com.weknow.wh.service;

import com.weknow.wh.model.WeKnowUser;

public interface WeKnowUserServiceI {
	int insert(WeKnowUser record);

    int insertSelective(WeKnowUser record);

}
