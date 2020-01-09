package com.admin.base.domain;

import com.admin.base.layui.annos.Field;
import com.admin.base.layui.annos.LayuiTable;
import com.admin.base.layui.annos.Query;
import com.admin.base.layui.annos.TableType;
import com.admin.base.layui.enums.Method;
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
 * ClassName: Role <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/7 0007 - 10:38
 */
@Data
@TableName("role")
@LayuiTable(elem = "role_table", value = @TableType(toolbar = true))
public class Role {

    @TableId(type = IdType.UUID)
    private String roleId;

    @Field(title = "角色名称")
    @Query(name = "角色名称",method = Method.LIKE)
    private String roleName;

    @Field(title = "创建时间")
    private Date createTime;

    private Date updateTime;

}
