package com.admin.base.domain;

import com.admin.base.annotation.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.annotatoin.Version;
import org.beetl.sql.core.orm.OrmQuery;

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
public class User extends TailBean implements Serializable {

    /* 雪花算法随机ID */
    @AssignID("simple")
    /* 防止大整数精度丢失 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userDid;

    @Field(field = "userName", title = "账号")
    private String userName;
    @Field(field = "userNickName", title = "用户名")
    private String userNickname;
    @JsonIgnore
    private String userPass;

    private Integer userState;
    @Field(field = "userCreateTime", title = "创建时间")
    private Date userCreateTime;

    /* 乐观锁 */
    @Version
    private Integer userVersion;

}
