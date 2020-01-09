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
 * ClassName: Resource <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/7 0007 - 12:23
 */
@Data
@TableName("resource")
public class Resource {

    @TableId(type = IdType.UUID)
    private String resourceId;
    private String resourceName;
    private String resourceComment;
    private Date createTime;
    private Date updateTime;
}
