package com.admin.base.controller;

import com.admin.base.domain.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: JsonController <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/26 0026 - 20:08
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class JsonController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/json1.do")
    @ResponseBody
    public Map json1() throws IOException {

        //方式一：Jackson树遍历
        Map map = new HashMap();
        String json = "{\"name\":\"zhangsan\",\"age\":\"18\",\"sex\":\"男\"}";
        JsonNode node = objectMapper.readTree(json);
        map.put("name", node.get("name").asText());
        map.put("age", node.get("age").asText());
        map.put("sex", node.get("sex").asText());
        return map;
    }


    @GetMapping(value = "/json2.do")
    @ResponseBody
    public User json2() throws IOException {

        //方式二：对象绑定
        String json = "{\"name\":\"zhangsan\",\"age\":\"18\",\"sex\":\"男\"}";
        User user = objectMapper.readValue(json, User.class);
        System.out.println(user);
        return user;
    }


}
