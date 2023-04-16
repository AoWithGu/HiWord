package com.powernode.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouterConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("anime-id", r -> r.path("/anime")
                        .uri("https://www.bilibili.com/"))
                .route("variety-id", r -> r.path("/variety")
                        .uri("https://www.bilibili.com/"))
                .route("kichiku-id", r -> r.path("/v/kichiku")
                        .uri("https://www.bilibili.com/"))
                .route("tech-id", r -> r.path("/v/tech")
                        .uri("https://www.bilibili.com/"))
                .build();
    }

}
