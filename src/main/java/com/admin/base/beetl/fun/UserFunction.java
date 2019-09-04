package com.admin.base.beetl.fun;

import com.admin.base.annotation.Field;
import com.admin.base.annotation.Layui;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * ClassName: UserFunction <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/4 0004 - 0:05
 */
@Component
public class UserFunction implements Function {

    @Autowired
    private SQLManager sqlManager;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @param paras 传递全类名
     * @param ctx
     * @return
     */
    @Override
    public Object call(Object[] paras, Context ctx) {
        try {
            Class<?> clazz = Class.forName(paras[0].toString());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.admin.base.domain.User");
        Layui layui = new Layui();
        Stream.of(clazz.getDeclaredFields())
                .forEach((info) -> {
                    Field field = info.getAnnotation(Field.class);
                    if (field != null) {
                        Layui.Col col = layui.getCol();
                        col.setField(field.field());
                        col.setTitle(field.title());
                        layui.add(col);
                    }
                });
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(layui);
        System.out.println(s);

    }
}
