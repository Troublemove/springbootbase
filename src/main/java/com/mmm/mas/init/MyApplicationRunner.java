package com.mmm.mas.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 与commandlinerunner实现相同的操作
 * MyApplicationRunner  先执行
 *
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
	
	private Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(args.toString());
		logger.info("...init resources by implements ApplicationRunner");
	}

}
