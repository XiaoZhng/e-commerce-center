package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XiaoZhag
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MemberNacosConsumerApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosConsumerApplication8080.class, args);
    }
}