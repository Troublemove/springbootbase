package com.mmm.mas.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务业务处理类，我们继承QuartzJobBean
 * 重写executeInternal方法来实现具体的定时业务逻辑
 */
@EnableScheduling
@Configuration
public class MyJob {
	
	private Logger logger = LoggerFactory.getLogger(MyJob.class);
	
	public MyJob() {
		super();
	}

	@Scheduled(cron = "*/5 * * * * ?")
	public void task(){
		logger.info(" ----  EnableScheduling");
	}

}
