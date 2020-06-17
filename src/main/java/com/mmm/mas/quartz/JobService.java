package com.mmm.mas.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	
	private Logger logger = LoggerFactory.getLogger(JobService.class);
	
//    @Scheduled(cron = "*/5 * * * * *")
    public void printTime() {
    	logger.info("JobService  --  ");
    }
}
