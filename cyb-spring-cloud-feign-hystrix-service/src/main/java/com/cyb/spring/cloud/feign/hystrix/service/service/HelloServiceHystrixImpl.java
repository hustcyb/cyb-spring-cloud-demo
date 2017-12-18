package com.cyb.spring.cloud.feign.hystrix.service.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrixImpl implements HelloService {

	@Override
	public String hello(String name) {
		return "Hi, " + name + ", sorry, error!";
	}

}
