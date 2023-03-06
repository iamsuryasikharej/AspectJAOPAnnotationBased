package com.surya.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surya.services.DemoService;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("/com/surya/resources/applicationContext.xml");
		DemoService demoService=(DemoService)applicationContext.getBean("demoService");
		demoService.getService1();
	}

}
