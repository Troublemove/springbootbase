package com.mmm.mas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		return "Hello, Zbook!";
	}
	
	@RequestMapping("/uu")
	public String uu() {
		return env.getProperty("uu");
	}
}
