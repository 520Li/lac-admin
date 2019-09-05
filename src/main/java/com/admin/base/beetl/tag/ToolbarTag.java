package com.admin.base.beetl.tag;


import com.admin.base.annotation.TableType;
import org.apache.commons.lang.StringUtils;
import org.beetl.core.tag.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ToolbarTag extends Tag {

    @Value("${clazz.path}")
    private String clazzPath;

    @Override
    public void render() {
        try {
            Class<?> clazz = Class.forName(clazzPath + args[0].toString());
            TableType tableType = clazz.getAnnotation(TableType.class);
            StringBuilder sb = new StringBuilder();

            //TODO  这里应该获取用户权限按钮

            sb.append("<script type=\"text/html\" id=\"" + tableType.toolbar() + "\">\n" +
                    "    <a class=\"layui-btn layui-btn-primary layui-btn-xs\" lay-event=\"edit\">修改</a>\n" +
                    "    <a class=\"layui-btn layui-btn-xs\" lay-event=\"reset\">重置密码</a>\n" +
                    "</script>");

            ctx.byteWriter.writeObject(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
