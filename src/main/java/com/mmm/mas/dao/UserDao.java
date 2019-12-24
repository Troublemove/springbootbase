package com.mmm.mas.dao;

import org.springframework.stereotype.Repository;

import com.mmm.mas.entity.User;

@Repository
public interface UserDao {

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}