package com.admin.base.service;

import com.admin.base.domain.User;
import com.admin.base.util.QueryVo;
import com.admin.base.util.PageResult;

import java.util.List;

/**
 * ClassName: UserService <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/26 0026 - 19:41
 */
public interface UserService {

    public User getUserById(Long id);

    public List<User> select(String name);

    public List<User> selectByDeprtmentId(Long id);

    public PageResult<User> pageUser(User template, QueryVo vo);

    public User LoginUser(User user);

    void restPsw(Long userId);

    void updateStatus(Long userId, Integer state);
}
