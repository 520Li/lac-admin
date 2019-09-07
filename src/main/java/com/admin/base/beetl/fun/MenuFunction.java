package com.admin.base.beetl.fun;

import com.admin.base.domain.Menu;
import com.admin.base.domain.Role;
import com.admin.base.domain.User;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.QueryCondition;
import org.beetl.sql.core.query.interfacer.QueryConditionI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

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
    @Autowired
    private HttpSession session;

    //菜单缓存
    private static Map<String, Object> map = new HashMap<>();

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
        User user = (User) session.getAttribute("login_user");
        //获取用户菜单
        List<Menu> menus = (List<Menu>) map.get("menus");
        if (menus == null) {
            menus = sqlManager.select("account.common.getMenusByUser", Menu.class, user);
            map.put("menus", menus);
        }

        menus = menus.stream()
                .filter((info) -> info.getMenuParent() == id)
                .collect(Collectors.toList());

        /*List<Menu> menus = sqlManager.lambdaQuery(Menu.class)
                .andEq(Menu::getMenuParent, id)
                .andEq(Menu::getMenuState, 1)
                .asc(Menu::getMenuSort)
                .select();*/
        return menus;
    }
}
