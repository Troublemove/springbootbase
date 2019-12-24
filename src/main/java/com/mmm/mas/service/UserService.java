package com.mmm.mas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.mas.dao.UserDao;
import com.mmm.mas.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userMapper;
	
	public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
	
}
