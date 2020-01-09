package com.admin.base.beetl.fun;

import com.admin.base.layui.*;
import com.admin.base.layui.annos.Field;
import com.admin.base.layui.annos.LayuiTable;
import com.admin.base.layui.annos.TableType;
import com.admin.base.layui.enums.FieldType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 输出一个Layui数据表格 <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/4 0004 - 0:05
 */
@Component
public class TableFunction implements Function {

    @Autowired
    private ObjectMapper objectMapper;
    @Value("${clazz.path}")
    private String clazzPath;

    /**
     * @param paras 实体类类名
     * @param ctx
     * @return
     */
    @Override
    public Object call(Object[] paras, Context ctx) {
        try {
            Class<?> clazz = Class.forName(clazzPath + paras[0].toString());

            // 1  数据表格属性
            LayuiTable table = clazz.getAnnotation(LayuiTable.class);
            Layui layui = new Layui("#" + table.elem(), table.url() + "?clazz=" + clazz.getSimpleName(), table.page());

            // 2  表格头部序列
            TableType tableType = table.value();
            Layui.Col col1 = layui.getCol();
            col1.setType(tableType.type());
            layui.add(col1);

            // 3  表格内容
            Arrays.asList(clazz.getDeclaredFields())
                    .forEach((info) -> {
                        Field field = info.getAnnotation(Field.class);
                        if (field != null) {
                            Layui.Col col = layui.getCol();
                            col.setField(info.getName());
                            col.setTitle(field.title());
                            // TODO 根据字段类型添加不同样式
                            style(col, field.type());
                            layui.add(col);
                        }
                    });


            // 4  表格尾部工具栏
            if (tableType.toolbar()) {
                Layui.Col col = layui.getCol();
                col.setAlign(tableType.align());
                col.setToolbar("#" + tableType.toolbarId());
                col.setTitle(tableType.title());
                layui.add(col);
            }


            // 5  返回 数据表格id 和 数据表头
            Map map = new HashMap();
            map.put("tableId", table.elem());
            map.put("data", objectMapper.writeValueAsString(layui));
            map.put("toolbarId", tableType.toolbarId());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void style(Layui.Col col, FieldType type) {
        switch (type) {
            case TEXT:
                break;
            case EDIT_TEXT:
                break;
            case SWITCH:
                col.setTemplet("#" + col.getField() + "_switch");
                break;
            case SELECT:
                break;
        }
    }


    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.admin.base.domain.User");
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
    }
}
