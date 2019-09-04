package com.admin.base.controller;

import com.admin.base.domain.User;
import com.admin.base.service.UserService;
import com.admin.base.util.QueryVo;
import com.admin.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * ClassName: SystemController <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/1 0001 - 19:01
 */
@Controller
@RequestMapping("/system/user")
public class SystemController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String toUser(ModelMap map) {
        return "system/user.html";
    }

    @GetMapping("/list.do")
    @ResponseBody
    public PageResult<User> getUserList(User user, QueryVo vo) {
        return userService.pageUser(user, vo);
    }

    @GetMapping("/editForm")
    public void editForm(Long userId) {
    }

    @PostMapping("/restPsw.do")
    @ResponseBody
    public PageResult restPsw(Long userId) {
        userService.restPsw(userId);
        return new PageResult(200, "重置密码成功");
    }

    @PostMapping("/updateState.do")
    @ResponseBody
    public PageResult updateState(Long userId, Integer state) {
        userService.updateStatus(userId, state);
        return new PageResult(200, "更新状态成功");
    }

}
