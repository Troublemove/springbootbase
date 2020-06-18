package com.mmm.mas.init;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;


/**
 * 初始化操作的顺序是最快的
 * 会阻塞运行时间
 *
 */
@Component
public class PostConstructRunner {
	
	@PostConstruct
	public void initSource() {
		System.out.println("...  PostConstruct ...");
	}
}
