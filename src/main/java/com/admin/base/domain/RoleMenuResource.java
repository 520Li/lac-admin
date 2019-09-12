package com.admin.base.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

import java.util.Date;

/**
 * ClassName: RoleMenuResource <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/7 0007 - 20:09
 */
@Data
@Table(name = "lac.lw_role_menu_resource")
public class RoleMenuResource {

    @AssignID("simple")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long rmrId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long rmrRoleId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long rmrRoleMrId;
    private Date rmrCreateTime;
    private Integer rmrVersion;
}
