package com.leaf.club.utils;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * @author xzl
 * 实现拦截器的分页功能
 *
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor {

    private int pageSize;
    private int currPage;
    private String dbType;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取statementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //获取statementHandler的包装类
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);

        while(metaObject.hasGetter("h")){
            Object obj = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(obj);
        }

        while(metaObject.hasGetter("target")){
            Object obj = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(obj);
        }

        MappedStatement statement = (MappedStatement)  metaObject.getValue("delegate.mappedStatement");
        String mapId = statement.getId();

        if(mapId.matches(".+ByPage$")){
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.mappedStatement");
            Map<String,Object> paraObj = (Map<String,Object>) parameterHandler.getParameterObject();

            currPage = (int) paraObj.get("currPage");
            pageSize = (int) paraObj.get("pageSize");
            String sql = (String) metaObject.getValue("delegate.boundSql.sql");

            String limitSql;
            sql = sql.trim();
            limitSql = sql + "limit" + (currPage - 1) * pageSize + "," + pageSize;

            metaObject.setValue("delegate.boundSql.sql",limitSql);
        }
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        String limit1 = properties.getProperty("limit","10");
        this.pageSize = Integer.valueOf(limit1);
        this.dbType = properties.getProperty("dbType","mysql");
    }
}
