package com.admin.base.annotation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Layui 数据表格实体类
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/4 0004 - 0:23
 */
@Data
public class Layui {

    /**
     * 表格id
     */
    private String elem;

    /**
     * 表格请求后台数据url
     */
    private String url;

    /**
     * 是否开启分页
     */
    private boolean page;

    /**
     * 表格数据对象（行 * 列）
     */
    private List<List<Col>> cols;

    public Layui() {
        cols = new ArrayList<>();
        LinkedList<Col> index0 = new LinkedList<>();
        cols.add(index0);
    }

    public Layui(String elem, String url, boolean page) {
        this();
        this.elem = elem;
        this.url = url;
        this.page = page;
    }

    public void add(Col col) {
        cols.get(0).add(col);
    }

    public Col getCol() {
        return new Col();
    }

    /**
     * 表格列
     */
    @JsonIgnoreType
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class Col {

        /**
         * 列头属性
         */
        private String type;

        /**
         * 列字段（与实体类对应）
         */
        private String field;

        /**
         * 列标题
         */
        private String title;

        /**
         * 列尾工具栏属性
         */
        private String align;

        /**
         * 工具栏id
         */
        private String toolbar;

        /**
         * 列模板
         */
        private String templet;


    }

}
