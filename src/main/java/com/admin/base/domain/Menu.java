package com.admin.base.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.annotatoin.Version;

import java.io.Serializable;

/**
 * ClassName: Menu <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/31 0031 - 14:57
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lac.lw_menu")
public class Menu implements Serializable {


    @AssignID("simple")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;
    private String menuName;
    private Long menuParent;
    private Integer menuSort;
    @JsonIgnore
    private Integer menuState;
    private String menuUrl;
    @JsonIgnore
    @Version
    private Integer menuVersion;


}
