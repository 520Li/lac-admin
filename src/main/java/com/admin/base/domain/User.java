package com.admin.base.domain;

import com.admin.base.layui.annos.Field;
import com.admin.base.layui.annos.LayuiTable;
import com.admin.base.layui.annos.Query;
import com.admin.base.layui.annos.TableType;
import com.admin.base.layui.enums.FieldType;
import com.admin.base.layui.enums.Method;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: User <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/25 0025 - 19:00
 */
@Data
@Table(name = "lac.lw_user")
@LayuiTable(elem = "user_table", value = @TableType(toolbarId = "user_toolbar"))
public class User implements Serializable {

    @AssignID("simple")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userDid;
    @Field("姓名")
    @Query(name = "姓名", method = Method.LIKE)
    private String userName;

    @Field("昵称")
    @Query(name = "昵称", method = Method.LIKE)
    private String userNickName;

    @JsonIgnore
    private String userPass;

    @Field("创建时间")
    private Date userCreateTime;

    @Field(value = "状态", type = FieldType.SWITCH)
    private Integer userState;


    private Integer userVersion;

}
