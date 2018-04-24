package com.windmt.springcloud.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-14 00:13
 **/
@Component
@FeignClient(name = "eureka-producer")
public interface HelloRemote {

    /**
     * 绑定 eureka-producer 服务的 /hello/ 接口
     * @param name
     * @return
     */
    @GetMapping("/hello/")
    String hello(@RequestParam(value = "name") String name);

}
