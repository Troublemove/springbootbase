package com.mmm.mas;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mmm.mas.dao")
public class MasApplication /*extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		System.out.println("... 1 SpringApplication.run()");
		SpringApplication.run(MasApplication.class, args);
		System.out.println("... 1-1 SpringApplication.run()");
	}
	
	@PostConstruct
	public void initSource1() {
		System.out.println("...  PostConstruct-001 ...");
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(MasApplication.class);
//	}

}
