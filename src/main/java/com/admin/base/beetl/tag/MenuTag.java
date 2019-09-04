package com.admin.base.beetl.tag;

import com.admin.base.domain.Menu;
import com.admin.base.service.HomeService;
import org.beetl.core.tag.Tag;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
public class MenuTag extends Tag {

    @Autowired
    private SQLManager sqlManager;

    @Override
    public void render() {
        /*try {
            int id = (int) getArgs()[0];
            List<Menu> menus = sqlManager.lambdaQuery(Menu.class).andEq(Menu::getMenuParent, id).select();
            ctx.globalVar.put("childMenus", menus);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
