package com.admin.base.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

import java.util.Date;

/**
 * ClassName: MenuResource <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/7 0007 - 12:25
 */
@Data
@Table(name = "lac.lw_menu_resource")
public class MenuResource {

    @AssignID("simple")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long mrId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long mrMenuId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long mrResourceId;
    private Date mrCreateTime;
    private Integer mrVersion;


}
