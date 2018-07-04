package com.atguigu.mapper.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.ibatis.type.JdbcType;

import lombok.Data;
import tk.mybatis.mapper.annotation.ColumnType;
@Data
@Table(name="user_info")
public class User {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer sid;
	private String sid;
	@Column(name="sname")
	private String s_name;
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String saddr;
	private String sphone;

}
