package com.windmt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: yibo
 * @create: 2018-04-18 09:48
 **/
@FeignClient(name = "producer", fallback = HelloRemote.HelloHystrix.class)
public interface HelloRemote {

    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

    @Component
    class HelloHystrix implements HelloRemote {

        @Override
        public String hello(String name) {
            return "Hello World!";
        }
    }

}
