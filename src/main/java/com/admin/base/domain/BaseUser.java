package com.admin.base.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BaseUser <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/26 0026 - 20:20
 */
public abstract class BaseUser {
    protected Map<String, Object> map = new HashMap();

    @JsonAnyGetter
    public Map<String, Object> getOther() {
        return map;
    }

    @JsonAnySetter
    public void setOther(String key, String value) {
        this.map.put(key, value);
    }

}