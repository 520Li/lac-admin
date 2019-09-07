package com.admin.base.service.impl;

import com.admin.base.domain.User;
import com.admin.base.service.UserService;
import com.admin.base.util.PageResult;
import com.admin.base.util.QueryVo;
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
    private SQLManager sqlManager;

    /**
     * 根据主键获取用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        return sqlManager.single(User.class, id);
    }

    @Override
    public List<User> select(String name) {
        User template = new User();
        template.setUserName(name);
        return sqlManager.template(template);
    }

    @Override
    public List<User> selectByDeprtmentId(Long id) {
        /*return userDao.selectByDepartId(id);*/
        User template = new User();
        template.setUserDid(id);
        return sqlManager.template(template);

    }

    /**
     * 分页查询用户列表
     *
     * @param vo
     * @return
     */
    @Override
    public PageResult<User> pageUser(User user, QueryVo vo) {
        PageQuery<User> query = new PageQuery<>(vo.getPage(), vo.getLimit());
        query.setParas(user);
        sqlManager.pageQuery("account.user.getUserPage", User.class, query);
        return new PageResult<>(query.getTotalRow(), query.getList());
    }

    /**
     * 用户登录校验
     *
     * @param user
     * @return
     */
    @Override
    public User LoginUser(User user) {
        User single = sqlManager.lambdaQuery(User.class).andEq(User::getUserName, user.getUserName())
                .andEq(User::getUserPass, user.getUserPass()).single();
        return single;
    }

    /**
     * 重置密码
     *
     * @param userId
     */
    @Override
    public void restPsw(Long userId) {
        User template = sqlManager.single(User.class, userId);
        template.setUserPass("1");
        sqlManager.updateTemplateById(User.class, template);
    }

    /**
     * 更新状态
     *
     * @param userId
     * @param state
     */
    @Override
    public void updateStatus(Long userId, Integer state) {
        User template = sqlManager.single(User.class, userId);
        template.setUserState(state);
        sqlManager.updateTemplateById(User.class, template);
    }

}
