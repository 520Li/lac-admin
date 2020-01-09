package com.admin.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

import java.util.Date;

/**
 * ClassName: UserRole <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/7 0007 - 12:20
 */
@Data
@TableName("user_role")
public class UserRole {

    @TableId(type = IdType.UUID)
    private String urId;
    private String userId;
    private String roleId;
    private Date createTime;
    private Date updateTime;
}
