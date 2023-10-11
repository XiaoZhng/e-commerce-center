package com.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoZhag
 * RibbonRule：配置自己的负载均衡算法
 */
//@Configuration
public class RibbonRule {

    //配置注入负载均衡算法
    @Bean
    public IRule myRibbon(){
        //返回的是 RandomRule，也可以根据业务需求来自己指定
        return new RandomRule(); //随机结果
    }
}
