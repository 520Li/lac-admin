package com.admin.base.controller;

import com.admin.base.domain.User;
import com.admin.base.service.HomeService;
import com.admin.base.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * ClassName: LoginController <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/25 0025 - 19:53
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private HomeService homeService;

    @PostMapping("/login.do")
    @ResponseBody
    public String index(HttpSession session, ModelMap map, User user) {
        try {
            //TODO 账号密码校验
            User isExist = userService.LoginUser(user);
            if (isExist != null) {
                isExist.setUserPass(null);
                session.setAttribute("login_user", isExist);
                session.setMaxInactiveInterval(5 * 60);
                return "{\"flag\":true}";
            } else {
                throw new Exception("用户名或密码错误");
            }
        } catch (Exception e) {
            return "{\"flag\":false,\"msg\":\"" + e.getMessage() + "\"}";
        }
    }

    @GetMapping("/")
    public String index(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute("login_user");
        map.put("login_user", user);
        // TODO  获取菜单资源
        /*List<Menu> menus = homeService.getMenus();
        map.put("menus", menus);*/

        return "/index.html";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("login_user");
        return "/login.html";
    }



}
