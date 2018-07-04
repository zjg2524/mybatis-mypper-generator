package com.atguigu.mapper.mymapper;

import org.apache.ibatis.annotations.UpdateProvider;

public interface MyBatchUpdateMapper {
	@UpdateProvider(type=MyBatchUpdatePovider.class,method="dynamicSQL")
	void batchUpdate();

}
