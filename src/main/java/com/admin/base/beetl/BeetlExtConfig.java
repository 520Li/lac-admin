package com.admin.base.beetl;

import com.admin.base.beetl.fun.MenuFunction;
import com.admin.base.beetl.fun.TableFunction;
import com.admin.base.beetl.tag.QueryTag;
import com.admin.base.beetl.tag.ToolbarTag;
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
    private TableFunction tableFunction;

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public BeetlTemplateCustomize beetlTemplateCustomize() {
        return new BeetlTemplateCustomize() {
            public void customize(GroupTemplate groupTemplate) {
                // 注册扩展函数
                groupTemplate.registerFunction("Menu", menuFunction);
                groupTemplate.registerFunction("Table", tableFunction);


                // 注册标签函数
                groupTemplate.registerTagFactory("QueryTag", new TagFactory() {
                    public Tag createTag() {
                        return applicationContext.getBean(QueryTag.class);
                    }
                });
                groupTemplate.registerTagFactory("ToolbarTag", new TagFactory() {
                    public Tag createTag() {
                        return applicationContext.getBean(ToolbarTag.class);
                    }
                });
            }

        };
    }
}