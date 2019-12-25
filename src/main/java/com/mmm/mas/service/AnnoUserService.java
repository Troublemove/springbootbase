package com.mmm.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmm.mas.dao.AnnoUserDao;
import com.mmm.mas.entity.User;

@Service
public class AnnoUserService {
	
	@Autowired
	private AnnoUserDao annoUserDao;
	
	/**
	 * 添加了分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<User> getAllUserList(int pageNum, int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = annoUserDao.getAllUserList();
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return pageInfo;
	}
	
	public User getUserByid(int id, String name) {
		return annoUserDao.getUserByIdAndName(id, name);
	}
}
