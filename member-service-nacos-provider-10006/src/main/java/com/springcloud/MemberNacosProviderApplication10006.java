package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XiaoZhag
 */
@EnableDiscoveryClient //引入的是 Nacos 发现注解
@SpringBootApplication
public class MemberNacosProviderApplication10006 {
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosProviderApplication10006.class, args);
    }
}