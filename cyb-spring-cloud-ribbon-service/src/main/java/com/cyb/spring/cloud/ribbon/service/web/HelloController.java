package com.cyb.spring.cloud.ribbon.service.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.spring.cloud.ribbon.service.service.HelloService;

@RestController
public class HelloController {
	
	@Resource
	private HelloService helloService;

	@RequestMapping("hello")
	public String hello(@RequestParam String name) {
		return helloService.hello(name);
	}
}
