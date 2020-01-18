package com.admin.base.domain;

import com.admin.base.layui.annos.Field;
import com.admin.base.layui.annos.LayuiTable;
import com.admin.base.layui.annos.Query;
import com.admin.base.layui.annos.TableType;
import com.admin.base.layui.enums.Method;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("menu")
@LayuiTable(elem = "menu_table")
public class Menu implements Serializable {


    @TableId(type = IdType.UUID)
    private String menuId;
    @Field(title = "菜单名称")
    @Query(name = "菜单名称", method = Method.LIKE)
    private String menuName;
    private String menuParent;
    @Field(title = "菜单级别")
    private String menuLevel;
    private Integer menuSort;
    private String menuState;
    @Field(title = "菜单url")
    private String menuUrl;


    private Date createTime;
    private Date updateTime;


}
