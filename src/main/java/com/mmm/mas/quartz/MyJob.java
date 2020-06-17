package com.mmm.mas.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务业务处理类，我们继承QuartzJobBean
 * 重写executeInternal方法来实现具体的定时业务逻辑
 */
public class MyJob extends QuartzJobBean{
	
	private Logger logger = LoggerFactory.getLogger(MyJob.class);

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("quartz  --  ");
	}

}
