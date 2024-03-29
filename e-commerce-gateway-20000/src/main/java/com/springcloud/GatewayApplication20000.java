package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoZhag
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication20000 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication20000.class, args);
    }
}