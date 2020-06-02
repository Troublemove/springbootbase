package com.mmm.mas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.mmm.mas.entity.User;
import com.mmm.mas.service.UserService;

@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService annoUserService;
	
	// 注解形式
//	@GetMapping("/allList")
//	public ServerResponse<List<User>> getUserList() {
//		logger.error("这是error日志");
//		return ServerResponse.createBySuccess("success", annoUserService.getAllUserList());
//	}
	
	@GetMapping("/userlist")
	public ModelAndView getAllList(Model model, PageInfo<?> pageInfo) {
		ModelAndView m = new ModelAndView();
		int pageNum  = (pageInfo.getPageNum() == 0)? 1 : pageInfo.getPageNum();
		int pageSize  = (pageInfo.getPageSize() == 0)? 10 : pageInfo.getPageSize();
		PageInfo<User> result = annoUserService.getAllUserList(pageNum, pageSize);
		// 设置页面信息
		pageInfo.setPageNum(pageNum);
		pageInfo.setPages(result.getPages());
		m.addObject("users", result.getList());
		m.addObject("pageInfo", pageInfo);
		return m;
	}
}
