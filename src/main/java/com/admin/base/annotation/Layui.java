package com.admin.base.annotation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Layui <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/9/4 0004 - 0:23
 */
@Data
@AllArgsConstructor
@Builder
public class Layui {

    private String elem;
    private String url;
    private boolean page;
    private List<List<Col>> cols;

    public Layui() {
        cols = new ArrayList<>();
        LinkedList<Col> index0 = new LinkedList<>();
        cols.add(index0);
    }

    public void add(Col col) {
        cols.get(0).add(col);
    }

    public Col getCol() {
        return new Col();
    }

    public class Col {
        private String field;
        private String title;


        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }


}
