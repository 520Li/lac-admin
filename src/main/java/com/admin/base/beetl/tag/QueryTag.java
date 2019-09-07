package com.admin.base.beetl.tag;

import com.admin.base.layui.annos.Query;
import org.beetl.core.tag.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 查询标签 <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/31 0031 - 15:27
 */
@Component
@Scope("prototype")
public class QueryTag extends Tag {

    @Value("${clazz.path}")
    private String clazzPath;

    @Override
    public void render() {
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> clazz = Class.forName(clazzPath + args[0].toString());
            Arrays.asList(clazz.getDeclaredFields())
                    .forEach((info) -> {
                        Query query = info.getAnnotation(Query.class);
                        if (query != null) {
                            switch (query.type()) {
                                case INPUT:
                                    sb.append(query.name() + "：<input id=\"" + info.getName() + "\" class=\"layui-input search-input\" type=\"text\"/>&emsp;");
                                    break;
                                case SELECT:
                                    break;
                                case DATETIME:
                                    break;
                            }
                        }
                    });
            ctx.byteWriter.writeObject(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
