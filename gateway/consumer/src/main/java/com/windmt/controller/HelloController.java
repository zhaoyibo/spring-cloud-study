package com.windmt.controller;

import com.windmt.feign.HelloRemote;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: yibo
 **/
@CommonsLog
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    HelloRemote helloRemote;

    @GetMapping("/{name}")
    public String index(@PathVariable("name") String name) throws InterruptedException {
        log.info("the name is " + name);
        switch (name) {
            case "null":
                throw new NullPointerException();
            case "retry":
                TimeUnit.MINUTES.sleep(10);
        }
        return helloRemote.hello(name) + "\n" + new Date().toString();
    }

}
