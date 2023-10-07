package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoZhag
 */
//@EnableEurekaClient：将该程序标识为 eureka client
@EnableEurekaClient
@SpringBootApplication
public class MemberApplication10000 {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication10000.class, args);
    }
}
