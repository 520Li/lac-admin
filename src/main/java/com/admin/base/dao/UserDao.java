package com.admin.base.dao;

import com.admin.base.domain.User;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * ClassName: UserDao <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/27 0027 - 17:24
 */
@SqlResource("account/user")
public interface UserDao extends BaseMapper<User> {

    public List<User> selectByDepartId(@Param("departId") Integer departId);

}
