package com.windmt.controller;

import com.windmt.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: zhaoyibochn@gmail.com
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @GetMapping("/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return helloRemote.hello(name + "\n" + new Date());
    }

}
