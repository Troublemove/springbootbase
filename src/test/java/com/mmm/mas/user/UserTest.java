package com.mmm.mas.user;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mmm.mas.entity.User;
import com.mmm.mas.service.UserService;

/**
 * SpringBoot 测试类
 *
 * @RunWith:启动器 SpringJUnit4ClassRunner.class：让 junit 与 spring 环境进行整合
 * @SpringBootTest(classes={App.class}) 1, 当前类为 springBoot 的测试类
 * @SpringBootTest(classes={App.class}) 2, 加载 SpringBoot 启动类。启动springBoot
 * junit 与 spring 整合@Contextconfiguartion("classpath:applicationContext.xml")
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserService annoUserDao;

	@Test
	public void testGetUserByIdAndName() {
		int id = 15;
		String name = "1";
		User u = annoUserDao.getUserByIdAndName(id, name);
		System.out.println(u);
	}
	
	@Test
	public void testGetOtherUserByIdAndName() {
		int id = 15;
		String name = "1";
		User u = annoUserDao.getOtherUserByIdAndName(id, name);
		System.out.println(u);
	}
}
