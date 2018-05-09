package com.windmt.controller;

import com.windmt.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String index(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response) {
        String time = new Date().toString();
        String header = response.getHeader("X-Response-Test");
        if (header != null && !header.isEmpty()) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        } else {
            response.addHeader("X-Response-Test", time);
        }
        return helloRemote.hello(name) + "\n" + time;
    }

}
