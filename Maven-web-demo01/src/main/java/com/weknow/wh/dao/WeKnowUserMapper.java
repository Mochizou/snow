package com.weknow.wh.dao;

import com.weknow.wh.model.WeKnowUser;

public interface WeKnowUserMapper {
    int insert(WeKnowUser record);

    int insertSelective(WeKnowUser record);
}