package com.admin.base.service.impl;

import com.admin.base.dao.UserMapper;
import com.admin.base.domain.User;
import com.admin.base.service.UserService;
import com.admin.base.util.PageResult;
import com.admin.base.util.QueryVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: UserServiceImpl <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/26 0026 - 19:41
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 根据主键获取用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> select(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUserName, name);
        return userMapper.selectList(wrapper);
    }

    @Override
    public List<User> selectByDeprtmentId(String id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUserDid, id);
        return userMapper.selectList(wrapper);

    }

    /**
     * 分页查询用户列表
     *
     * @param vo
     * @return
     */
   /* @Override
    public PageResult<User> pageUser(User user, QueryVo vo) {
        PageQuery<User> query = new PageQuery<>(vo.getPage(), vo.getLimit());
        query.setParas(user);
        sqlManager.pageQuery("account.user.getUserPage", User.class, query);
        return new PageResult<>(query.getTotalRow(), query.getList());
        PageQuery
    }*/

    /**
     * 用户登录校验
     *
     * @param user
     * @return
     */
    @Override
    public User LoginUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUserName, user.getUserName()).eq(User::getUserPass, user.getUserPass());
        return userMapper.selectOne(wrapper);
    }

    /**
     * 重置密码
     *
     * @param userId
     */
    @Override
    public void restPsw(String userId) {
        User user = userMapper.selectById(userId);
        user.setUserPass("1");
        userMapper.updateById(user);
    }

    /**
     * 更新状态
     *
     * @param userId
     * @param state
     */
    @Override
    public void updateStatus(String userId, String state) {
        User user = userMapper.selectById(userId);
        user.setUserState(state);
        userMapper.updateById(user);
    }

}
