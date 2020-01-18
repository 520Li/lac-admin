package com.admin.base.dao;

import com.admin.base.domain.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> getResourcesByUser(@Param("userId") String userId, @Param("menuId") String menuId);
}
