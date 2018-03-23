package com.weknow.wh.dao;

import com.weknow.wh.model.WebNode;

public interface WebNodeMapper {
    int insert(WebNode record);

    int insertSelective(WebNode record);
}