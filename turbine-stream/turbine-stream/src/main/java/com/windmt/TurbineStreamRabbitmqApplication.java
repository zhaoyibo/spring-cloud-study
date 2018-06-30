package com.windmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author yibo
 */
@EnableTurbineStream
@SpringBootApplication
public class TurbineStreamRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineStreamRabbitmqApplication.class, args);
    }

}
