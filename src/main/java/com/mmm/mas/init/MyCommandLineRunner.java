package com.mmm.mas.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 实现了 CommandLineRunner 接口的 Component 会在所有 Spring Beans 初始化完成之后
 *	order 越小先执行
 */
//@Order(1)
//@Component
public class MyCommandLineRunner implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(MyCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("...init resources by implements CommandLineRunner");
	}

}
