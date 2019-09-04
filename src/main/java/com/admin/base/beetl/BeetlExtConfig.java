package com.admin.base.beetl;

import com.admin.base.beetl.fun.MenuFunction;
import com.admin.base.beetl.fun.UserFunction;
import com.admin.base.beetl.tag.MenuTag;
import com.ibeetl.starter.BeetlTemplateCustomize;
import org.beetl.core.GroupTemplate;
import org.beetl.core.tag.Tag;
import org.beetl.core.tag.TagFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: BeetlExtConfig <br/>
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/31 0031 - 15:44
 */
@Configuration
public class BeetlExtConfig {

    @Autowired
    private MenuFunction menuFunction;
    @Autowired
    private UserFunction userFunction;

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public BeetlTemplateCustomize beetlTemplateCustomize() {
        return new BeetlTemplateCustomize() {
            public void customize(GroupTemplate groupTemplate) {
                // 注册一个扩展函数
                groupTemplate.registerFunction("Menu", menuFunction);
                groupTemplate.registerFunction("UserField", userFunction);

                // 注册一个标签函数
                /*groupTemplate.registerTagFactory("MenuTag", new TagFactory() {
                    public Tag createTag() {
                        return applicationContext.getBean(MenuTag.class);
                    }
                });*/
            }

        };
    }
}