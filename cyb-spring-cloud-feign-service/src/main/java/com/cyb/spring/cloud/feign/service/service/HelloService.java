package com.cyb.spring.cloud.feign.service.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${feign.client.hello}")
public interface HelloService {

	@GetMapping("/hello")
	String hello(@RequestParam(value = "name") String name);
}
