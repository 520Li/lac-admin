package com.admin.base.service;


import com.admin.base.domain.Menu;

import java.util.List;

/**
 * ClassName: HomeService <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/31 0031 - 14:55
 */
public interface HomeService {

    List<Menu> getMenus();

    Menu getMenuById(Long id);
}
