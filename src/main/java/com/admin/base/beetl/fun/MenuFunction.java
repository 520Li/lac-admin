package com.admin.base.beetl.fun;

import com.admin.base.domain.Menu;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义 菜单函数
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/31 0031 - 16:46
 */

@Component
public class MenuFunction implements Function {
    @Autowired
    private SQLManager sqlManager;

    /**
     * 根据父菜单id 获取子菜单
     *
     * @param paras
     * @param ctx
     * @return
     */
    @Override
    public Object call(Object[] paras, Context ctx) {
        Long id = Long.parseLong(paras[0] + "");

        //TODO 获取用户权限菜单

        List<Menu> menus = sqlManager.lambdaQuery(Menu.class).andEq(Menu::getMenuParent, id).andEq(Menu::getMenuState, 1).asc(Menu::getMenuSort).select();
        return menus;
    }
}
