package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoZhag
 */
@EnableEurekaClient
@SpringBootApplication
public class MemberConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberConsumerApplication.class, args);
    }
}