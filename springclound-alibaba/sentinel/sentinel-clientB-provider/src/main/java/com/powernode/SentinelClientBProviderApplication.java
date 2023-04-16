package com.powernode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelClientBProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelClientBProviderApplication.class, args);
    }

}
