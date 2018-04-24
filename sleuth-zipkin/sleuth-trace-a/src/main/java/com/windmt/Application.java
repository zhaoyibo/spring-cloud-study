package com.windmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author yibo
 */
@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private LoadBalancerExchangeFilterFunction lbFunction;


    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://trace-b")
                .filter(lbFunction)
                .build();
    }

    @GetMapping("/trace-a")
    public Mono<String> trace() {
        System.out.println("===call trace-a===");

        return webClient().get()
                .uri("/trace-b")
                .retrieve()
                .bodyToMono(String.class);
    }

}
