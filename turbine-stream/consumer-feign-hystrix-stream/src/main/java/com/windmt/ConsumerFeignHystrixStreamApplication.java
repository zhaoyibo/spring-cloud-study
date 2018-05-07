package com.windmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhaoyibochn@gmail.com
 */
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class ConsumerFeignHystrixStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignHystrixStreamApplication.class, args);
	}
}
