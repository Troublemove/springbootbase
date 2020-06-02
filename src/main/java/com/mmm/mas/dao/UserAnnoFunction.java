package com.mmm.mas.dao;

import org.apache.ibatis.jdbc.SQL;

/**
 * 第二种注解实现
 */
public class UserAnnoFunction {
	public String queryOtherUserByIdAndName(int id, String name) {
//		return "select * from User where id=#{id} and userName like #{name}";
		return new SQL().SELECT("id")
				.FROM("User")
				.WHERE("id = #{id}")
				.AND()
				.WHERE("userName like #{name}")
				.toString();
	}
}
