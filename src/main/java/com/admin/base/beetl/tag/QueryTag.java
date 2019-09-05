package com.admin.base.beetl.tag;

import com.admin.base.annotation.Query;
import com.admin.base.annotation.QueryType;
import com.admin.base.domain.Menu;
import com.admin.base.service.HomeService;
import org.beetl.core.tag.Tag;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 自定义 标签 <br/>
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
