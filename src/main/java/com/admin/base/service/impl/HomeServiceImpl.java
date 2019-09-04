package com.admin.base.service.impl;

import com.admin.base.domain.Menu;
import com.admin.base.domain.User;
import com.admin.base.service.HomeService;
import org.apache.tomcat.util.digester.ArrayStack;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: HomeServiceImpl <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/31 0031 - 14:55
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HttpSession session;
    @Autowired
    private SQLManager sqlManager;


    @Override
    public List<Menu> getMenus() {
        User user = (User) session.getAttribute("login_user");
        if (user.getUserName().equals("admin")) {
            return sqlManager.all(Menu.class);
        } else {
            // TODO  根据 用户 -> 角色 -> 菜单 获取菜单

            return new ArrayList<>();
        }

    }
}
