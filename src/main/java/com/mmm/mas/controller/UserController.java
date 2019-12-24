package com.mmm.mas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mmm.mas.common.ServerResponse;
import com.mmm.mas.entity.User;
import com.mmm.mas.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/getUserById/{id}")
	public ServerResponse<User> getUserList(@PathVariable("id") Integer id){
		return ServerResponse.createBySuccess("success", userService.selectByPrimaryKey(id));
	}
	
}
