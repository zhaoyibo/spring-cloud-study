package com.windmt;

import com.windmt.filter.ElapsedFilter;
import com.windmt.filter.RateLimitByCpuGatewayFilter;
import com.windmt.filter.RateLimitByIpGatewayFilter;
import com.windmt.filter.TokenFilter;
import com.windmt.filter.factory.ElapsedGatewayFilterFactory;
import com.windmt.filter.ratelimit.RemoteAddrKeyResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

/**
 * @author yibo
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(
                        r -> r.path("/fluent/customer/**")
                             .filters(f -> f.stripPrefix(2)
                                            .filter(new ElapsedFilter())
                                            .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                             .uri("lb://CONSUMER")
                             .order(0)
                             .id("fluent_customer_service")
                )
                .route(r -> r.path("/throttle/customer/**")
                             .filters(f -> f.stripPrefix(2)
                                            .filter(new RateLimitByIpGatewayFilter(10, 1, Duration.ofSeconds(1)))
                                            .filter(rateLimitByCpuGatewayFilter))
                             .uri("lb://CONSUMER")
                             .order(0)
                             .id("throttle_customer_service")
                )
                .build();
        // @formatter:on
    }

    @Autowired
    private RateLimitByCpuGatewayFilter rateLimitByCpuGatewayFilter;

    @Bean
    public ElapsedGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new ElapsedGatewayFilterFactory();
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

//    @Bean
//    public ElapsedFilter elapsedFilter(){
//        return new ElapsedFilter();
//    }

    @Bean(name = RemoteAddrKeyResolver.BEAN_NAME)
    public RemoteAddrKeyResolver remoteAddrKeyResolver() {
        return new RemoteAddrKeyResolver();
    }

}
