package com.admin.base.domain;

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
@Table(name = "lac.lw_user_role")
public class UserRole {

    @AssignID("simple")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long urId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long urUserId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long urRoleId;
    private Date urCreateTime;
    private Integer urVersion;
}