package com.cyb.spring.cloud.feign.hystrix.service.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.spring.cloud.feign.hystrix.service.service.HelloService;

@RestController
public class HelloController {

	@Resource
	private HelloService helloService;
	
	@GetMapping("hello")
	public String hello(@RequestParam String name) {
		return helloService.hello(name);
	}
}
