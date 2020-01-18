package com.admin.base.service;

import com.admin.base.domain.Resource;
import com.admin.base.domain.User;
import com.admin.base.util.PageResult;
import com.admin.base.util.QueryVo;

import java.util.List;
import java.util.Map;

public interface CommonService {

    public PageResult getCommonPage(QueryVo vo) throws Exception;

    void updateStatus(String id, String state, String clazz) throws Exception;


}
