package com.atguigu.mapper.mymapper;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import org.apache.ibatis.mapping.MappedStatement;
public class MyBatchUpdatePovider extends MapperTemplate{

	public MyBatchUpdatePovider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
		// TODO Auto-generated constructor stub
	}
	
	public void batchUpdate(MappedStatement mappedStatement)
	{
		
	}

}
