package com.admin.base.service;

import com.admin.base.util.PageResult;
import com.admin.base.util.QueryVo;

import java.util.Map;

public interface CommonService {

    public PageResult getCommonPage(QueryVo vo) throws Exception;
}
