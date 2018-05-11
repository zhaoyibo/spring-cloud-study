package com.windmt.controller;

import com.windmt.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: yibo
 **/
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    HelloRemote helloRemote;

    @GetMapping("/{name}")
    public String index(@PathVariable("name") String name) {
        if ("null".equals(name)) {
            throw new NullPointerException();
        }
        return helloRemote.hello(name) + "\n" + new Date().toString();
    }

}
