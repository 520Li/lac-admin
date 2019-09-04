package com.admin.base.beetl;

import org.apache.commons.lang.StringEscapeUtils;
import org.beetl.core.Format;

/**
 * ClassName: XXSDefenderFormat <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/27 0027 - 11:40
 */
public class XXSDefenderFormat implements Format {
    public Object format(Object data, String pattern) {
        if (data instanceof String) {
            String js = (String) data;
            String str = StringEscapeUtils.escapeHtml(js);
            return str;
        } else {
            return data;
        }
    }
}