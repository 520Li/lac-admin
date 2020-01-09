package com.admin.base.dao;

import com.admin.base.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenusByUser(String userId);
}
