package com.cyb.spring.cloud.ribbon.hystrix.service.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Resource
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "helloError")
	public String hello(String name) {
		String url = "http://cyb-spring-cloud-eureka-client/hello?name=" + name;
		return restTemplate.getForObject(url, String.class);
	}
	
	public String helloError(String name) {
		return "hi, " + name + ", sorry, error!";
	}
}
