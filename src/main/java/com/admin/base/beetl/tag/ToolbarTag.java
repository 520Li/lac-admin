package com.admin.base.beetl.tag;


import com.admin.base.domain.User;
import com.admin.base.layui.annos.LayuiTable;
import com.admin.base.layui.annos.TableType;
import org.beetl.core.tag.Tag;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 数据表格尾部工具栏标签
 */
@Component
public class ToolbarTag extends Tag {

    @Value("${clazz.path}")
    private String clazzPath;
    @Autowired
    private SQLManager sqlManager;
    @Autowired
    private HttpSession httpSession;

    @Override
    public void render() {
        try {
            Class<?> clazz = Class.forName(clazzPath + args[0].toString());
            TableType tableType = clazz.getAnnotation(LayuiTable.class).value();
            StringBuilder sb = new StringBuilder();

            //TODO  获取用户权限按钮
            User user = (User) httpSession.getAttribute("login_user");


            sb.append("<script type=\"text/html\" id=\"" + tableType.toolbarId() + "\">\n" +
                    "    <a class=\"layui-btn layui-btn-primary layui-btn-xs\" lay-event=\"edit\">修改</a>\n" +
                    "    <a class=\"layui-btn layui-btn-xs\" lay-event=\"reset\">重置密码</a>\n" +
                    "</script>");

            ctx.byteWriter.writeObject(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
