package com.admin.base.dao;

import com.admin.base.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: UserMapper <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/27 0027 - 17:24
 */
public interface UserMapper extends BaseMapper<User> {

    public List<User> selectByDepartId(@Param("departId") Integer departId);

}
