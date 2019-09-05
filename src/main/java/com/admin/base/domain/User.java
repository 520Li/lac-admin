package com.admin.base.domain;

import com.admin.base.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.annotatoin.Version;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lac.lw_user")
@LayuiTable
@TableType
public class User implements Serializable {

    /* 雪花算法ID */
    @AssignID("simple")
    /* 防止大整数精度丢失 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userDid;

    @Field(title = "账号")
    @Query(name = "账号", method = Method.LIKE)
    private String userName;

    @Field(title = "用户名")
    @Query(name = "用户名", method = Method.LIKE)
    private String userNickName;

    @JsonIgnore
    private String userPass;

    @Field(title = "创建时间")
    private Date userCreateTime;


    @Field(title = "状态", type = FieldType.SWITCH)
    private Integer userState;


    /* 乐观锁 */
    //@Version
    private Integer userVersion;

}
