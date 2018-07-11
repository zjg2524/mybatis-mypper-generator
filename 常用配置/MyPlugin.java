package com.atguigu.mapper.plugin;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
@Intercepts(
		{
			@Signature(type=StatementHandler.class,method="parameterize",args=java.sql.Statement.class)
		}
		
		)
public class MyPlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object target = invocation.getTarget();
		MetaObject forObject = SystemMetaObject.forObject(target);
		Object value = forObject.getValue("parameterHandler.parameterObject");
		BoundSql sql = (BoundSql) forObject.getValue("parameterHandler.boundSql");
		System.err.println("sql --> "+sql.getSql());
		System.err.println("  ****************sql*************  --> "+value);
		forObject.setValue("parameterHandler.parameterObject", 166);
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
