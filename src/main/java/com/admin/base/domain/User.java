package com.admin.base.domain;

import com.admin.base.layui.annos.Field;
import com.admin.base.layui.annos.LayuiTable;
import com.admin.base.layui.annos.Query;
import com.admin.base.layui.annos.TableType;
import com.admin.base.layui.enums.FieldType;
import com.admin.base.layui.enums.Method;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user")
@LayuiTable(elem = "user_table", value = @TableType(toolbar = true))
public class User implements Serializable {

<<<<<<< HEAD
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
=======
    @TableId(type = IdType.UUID)
    private String userId;
    private String userDid;
    @Field(title = "账号")
    @Query(name = "账号", method = Method.LIKE)
    private String userName;
    @Field(title = "用户名")
    @Query(name = "用户名", method = Method.LIKE)
>>>>>>> 2a12ffbf9ff4dcef15a466388f0a15eed7307196
    private String userNickName;
    @JsonIgnore
    private String userPass;
<<<<<<< HEAD

    @Field("创建时间")
    private Date userCreateTime;

    @Field(value = "状态", type = FieldType.SWITCH)
    private Integer userState;


    private Integer userVersion;
=======
    @Field(title = "创建时间")
    private Date createTime;
    private Date updateTime;
    @Field(title = "状态", type = FieldType.SWITCH)
    private String userState;

>>>>>>> 2a12ffbf9ff4dcef15a466388f0a15eed7307196

}
