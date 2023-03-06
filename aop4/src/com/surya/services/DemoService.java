package com.surya.services;

import org.springframework.stereotype.Component;

@Component
public class DemoService {
	public void getService1()
	{
		int i=1/0;
		System.out.println("in getService1");
	}
	public String getService2()
	{
		System.out.println("in getService2");
		return "returning from getService 2";
	}

}
