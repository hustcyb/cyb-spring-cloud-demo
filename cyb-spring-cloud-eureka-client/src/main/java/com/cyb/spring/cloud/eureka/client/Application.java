package com.cyb.spring.cloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class Application implements EnvironmentAware {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private String hostname;

	@Override
	public void setEnvironment(Environment environment) {
		hostname = environment.getProperty("HOSTNAME");
	}

	@RequestMapping("hello")
	public String hello(@RequestParam String name) {
		return "Hi " + name + ", I'm from " + hostname;
	}
}
