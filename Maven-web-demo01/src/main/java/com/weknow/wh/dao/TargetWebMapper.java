package com.weknow.wh.dao;

import com.weknow.wh.model.TargetWeb;

public interface TargetWebMapper {
    int insert(TargetWeb record);

    int insertSelective(TargetWeb record);
}