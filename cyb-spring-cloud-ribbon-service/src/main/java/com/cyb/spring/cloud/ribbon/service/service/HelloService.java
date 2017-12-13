package com.cyb.spring.cloud.ribbon.service.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Resource
	private RestTemplate restTemplate;
	
	public String hello(String name) {
		String url = "http://cyb-spring-cloud-eureka-client/hello?name=" + name;
		return restTemplate.getForObject(url, String.class);
	}
}
