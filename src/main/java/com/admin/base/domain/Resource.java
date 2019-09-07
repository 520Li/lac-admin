package com.admin.base.domain;

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
@Table(name = "lac.lw_resource")
public class Resource {

    @AssignID("simple")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long resourceId;
    private String resourceName;
    private String resourceComment;
    private Date resourceCreateTime;
    private Integer resourceVersion;
}
