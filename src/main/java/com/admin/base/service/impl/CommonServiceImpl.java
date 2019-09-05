package com.admin.base.service.impl;

import com.admin.base.domain.User;
import com.admin.base.service.CommonService;
import com.admin.base.util.PageResult;
import com.admin.base.util.QueryVo;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;
import java.util.Map;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    @Autowired
    private SQLManager sqlManager;
    @Value("${clazz.path}")
    private String clazzPath;

    @Override
    public PageResult getCommonPage(QueryVo vo) throws Exception {
        Class<?> clazz = Class.forName(clazzPath + vo.getClazz());
        PageQuery query = new PageQuery<>(vo.getPage(), vo.getLimit());
        query.setPara("tableName", getTableName(clazz));
        query.setPara("keys", vo.getMap().keySet());
        query.setPara("map", vo.getMap());
        sqlManager.pageQuery("account.common.getCommonPage", clazz, query);
        return new PageResult(query.getTotalRow(), query.getList());
    }

    /**
     * 获取数据库表名
     *
     * @param clazz
     * @return
     */
    private String getTableName(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        if (table == null) {
            return clazz.getSimpleName();
        }
        return table.name();
    }
}
