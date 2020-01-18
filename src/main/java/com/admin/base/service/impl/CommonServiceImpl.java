package com.admin.base.service.impl;

import com.admin.base.dao.ResourceMapper;
import com.admin.base.domain.Resource;
import com.admin.base.domain.User;
import com.admin.base.layui.enums.FieldType;
import com.admin.base.layui.enums.Method;
import com.admin.base.layui.annos.Query;
import com.admin.base.service.CommonService;
import com.admin.base.util.PageResult;
import com.admin.base.util.QueryVo;
import org.apache.commons.lang.StringUtils;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.annotatoin.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    @Value("${clazz.path}")
    private String clazzPath;
    @Autowired
    private SQLManager sqlManager;
    @Autowired
    private HttpSession session;

    /**
     * 公共分页查询方法
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public PageResult getCommonPage(QueryVo vo) throws Exception {
        Class<?> clazz = Class.forName(clazzPath + vo.getClazz());
        //方式一：md查询
        /*PageQuery query = new PageQuery<>(vo.getPage(), vo.getLimit());
        query.setPara("tableName", getTableName(clazz));
        List<String> list = getFilter(clazz, vo.getMap());
        query.setPara("list", list);
        sqlManager.pageQuery("account.common.getCommonPage", clazz, query);
        return new PageResult(query.getTotalRow(), query.getList());*/
        //方式二：动态拼接
        org.beetl.sql.core.query.Query<?> query = getFilter(clazz, vo.getMap());
        long count = query.count();
        org.beetl.sql.core.query.Query<?> query2 = getFilter(clazz, vo.getMap());
        List<?> datas = query2.limit(vo.getPage(), vo.getLimit()).select();
        return new PageResult(count, datas);
    }


    /**
     * 更改状态
     *
     * @param id
     * @param state
     */
    @Override
    public void updateStatus(String id, String state, String clazz) throws Exception {
        Class<?> className = Class.forName(clazzPath + clazz);
        Field[] fields = className.getDeclaredFields();
        Map map = new HashMap();
        map.put(fields[0].getName(), id);
        for (Field f : fields) {
            com.admin.base.layui.annos.Field anno = f.getAnnotation(com.admin.base.layui.annos.Field.class);
            if (anno != null && anno.type().equals(FieldType.SWITCH)) {
                map.put(f.getName(), state);
                break;
            }
        }
        sqlManager.updateTemplateById(className, map);
    }


    /**
     * 动态拼接条件
     *
     * @param clazz
     * @param map
     * @return
     */
    private org.beetl.sql.core.query.Query<?> getFilter(Class<?> clazz, Map<String, Object> map) {
        Field[] fields = clazz.getDeclaredFields();
        //查询query
        org.beetl.sql.core.query.Query<?> query = sqlManager.query(clazz);
        for (Field f : fields) {
            Query q = f.getAnnotation(Query.class);
            if (q != null) {
                String name = f.getName();
                if (map.containsKey(name) && StringUtils.isNotBlank(String.valueOf(map.get(name)))) {
                    String fieldName = f.getName().replaceAll("([A-Z])", "_$1").toLowerCase();
                    query = append(query, fieldName, q.method(), map.get(name));
                }
            }
        }
        return query;
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

    /**
     * 拼接过滤条件
     *
     * @return
     */
   /* private List<String> getFilter(Class<?> clazz, Map<String, Object> map) {
        Field[] fields = clazz.getDeclaredFields();
        List<String> list = new ArrayList<>();
        for (Field f : fields) {
            Query query = f.getAnnotation(Query.class);
            if (query != null) {
                String fieldName = f.getName().replaceAll("([A-Z])", "_$1").toLowerCase();
                if (map.containsKey(fieldName)) {
                    String str = append(fieldName, query.method(), map.get(fieldName));
                    list.add(str);
                }
            }
        }
        return list;
    }
*/

    /**
     * 拼接过滤条件
     *
     * @param fieldName
     * @param method
     * @param obj
     * @return
     */
    private org.beetl.sql.core.query.Query<?> append(org.beetl.sql.core.query.Query<?> query, String fieldName, Method method, Object obj) {
        switch (method) {
            case EQUALS:
                query.andEq(fieldName, obj);
                break;
            case LIKE:
                query.andLike(fieldName, "%" + obj + "%");
                break;
            case LESS:
                query.andLess(fieldName, obj);
                break;
            case LESSEQ:
                query.andLessEq(fieldName, obj);
                break;
            case MORE:
                query.andGreat(fieldName, obj);
                break;
            case MOREEQ:
                query.andGreatEq(fieldName, obj);
                break;
        }
        return query;
    }


}
