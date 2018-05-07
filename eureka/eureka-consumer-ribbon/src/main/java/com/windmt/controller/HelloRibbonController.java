package com.windmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author: yibo
 **/
@RequestMapping("/hello")
@RestController
public class HelloRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String hello(@RequestParam String name) {
        name += "!";
        String url = "http://eureka-producer/hello/?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

}
