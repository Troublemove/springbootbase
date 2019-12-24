package com.mmm.mas.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.mmm.mas.entity.User;

@Repository
public interface AnnoUserDao {

	// 使用注解
	@Select("select * from user")
	@Results({ @Result(property = "userName", column = "user_name"),
			@Result(property = "nickName", column = "nick_name"), 
			@Result(property = "regTime", column = "reg_time") })
	List<User> getAllUserList();

	@Select("select *from User where id=#{id} and userName like #{name}")
	public User getUserByIdAndName(@Param("id") int id, @Param("name") String name);
}
