package com.cyb.spring.cloud.feign.hystrix.service.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${feign.client.hello}", fallback = HelloServiceHystrixImpl.class)
public interface HelloService {

	@GetMapping("hello")
	public String hello(@RequestParam("name") String name);
}
