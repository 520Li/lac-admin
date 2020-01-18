package com.admin.base.domain;

import com.admin.base.layui.annos.Field;
import com.admin.base.layui.annos.LayuiTable;
import com.admin.base.layui.annos.Query;
import com.admin.base.layui.annos.TableType;
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
@Table(name = "lac.lw_role")
@LayuiTable(elem = "role_table", value = @TableType(toolbarId = "role_toolbar"))
public class Role {

    @AssignID("simple")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    @Field("角色名称")
    @Query(name = "角色名称")
    private String roleName;

    @Field("创建时间")
    private Date roleCreateTime;

    private Integer roleVersion;
}
