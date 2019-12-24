package com.mmm.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.mas.dao.AnnoUserDao;
import com.mmm.mas.entity.User;

@Service
public class AnnoUserService {
	
	@Autowired
	private AnnoUserDao annoUserDao;
	
	public List<User> getAllUserList(){
		return annoUserDao.getAllUserList();
	}
	
	public User getUserByid(int id, String name) {
		return annoUserDao.getUserByIdAndName(id, name);
	}
}
