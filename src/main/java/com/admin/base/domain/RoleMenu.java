package com.admin.base.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

import java.util.Date;

/**
 * ClassName: RoleMenu <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/7 0007 - 12:17
 */
@Data
@Table(name = "lac.lw_role_menu")
public class RoleMenu {

    @AssignID("simple")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long rmId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long rmRoleId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long rmMenuId;
    private Date rmCreateTime;
    private Integer rmVersion;

}
