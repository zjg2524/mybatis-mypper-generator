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

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = java.sql.Connection.class) }

)
public class MyPlugin2 implements Interceptor {

	private static final String SQL_POSITION = "delegate.boundSql.sql";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object target = invocation.getTarget();
		MetaObject forObject = SystemMetaObject.forObject(target);
		String value = (String) forObject.getValue(SQL_POSITION);
		if(value !=null && value.contains("for update"))
		{
			value = value.replaceAll("for update", "");
		}
		System.err.println("value --> " + value);
		
		forObject.setValue(SQL_POSITION, value);
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
