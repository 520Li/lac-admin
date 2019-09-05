package com.admin.base.beetl.tag;

import com.admin.base.annotation.FieldType;
import org.beetl.core.tag.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * ClassName: SwitchTag <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/5 0005 - 23:15
 */
@Component
public class SwitchTag extends Tag {

    @Value("${clazz.path}")
    private String clazzPath;

    @Override
    public void render() {
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> clazz = Class.forName(clazzPath + args[0].toString());
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                com.admin.base.annotation.Field anno = f.getAnnotation(com.admin.base.annotation.Field.class);
                if (anno != null && anno.type().equals(FieldType.SWITCH)) {
                    sb.append("<script type=\"text/html\" id=\"" + f.getName() + "_switch" + "\">\n" +
                            "    <input type=\"checkbox\" lay-filter=\"" + f.getName() + "_switch" + "\" value=\"{{d." + fields[0].getName() + "}}\" lay-skin=\"switch\" lay-text=\"正常|锁定\"\n" +
                            "           {{d." + f.getName() + "==0?'checked':''}}/>\n" +
                            "</script>");
                }
            }
            ctx.byteWriter.writeObject(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
