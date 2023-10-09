package com.springcloud.controller;

import com.springcloud.entity.Member;
import com.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XiaoZhag
 */
@RestController
@Slf4j
public class MemberConsumerController {

    //定义 MEMBER_SERVICE_PROVIDER_URL 基础 url 地址
    //shift + ctrl + U：大小写切换
    /**
     * 1.MEMBER-SERVICE-PROVIDER 就是服务提供方【集群】，注册到 Eureka Server 的名称
     * 2.也就是服务提供方【集群】对外暴露的名称为 MEMBER-SERVICE-PROVIDER
     * 3.MEMBER-SERVICE-PROVIDER 目前有两个 Availability Zones member-service-provider:10000
     *   还有一个 member-service-provider:10002
     *   还需要增加一个注解 @LoadBalanced 赋予 RestTemplate 负载均衡的能力，也就是会根据你的负载均衡算法
     *   来选择某个服务去访问，默认是轮询算法，我们也可以自己配置负载均衡算法
     */
    public static final String MEMBER_SERVICE_PROVIDER_URL =
            "http://MEMBER-SERVICE-PROVIDER";

    //装配 RestTemplate
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/member/consumer/discovery")
    public Object getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务名={}", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("id={}, host={},post={},uri={}", instance.getServiceId(),
                        instance.getHost(), instance.getPort(), instance.getUri());

            }
        }
        return discoveryClient;
    }

    @PostMapping("/member/consumer/save")
    //方法/接口 添加 member 对象到数据库/表
    public Result save(Member member) {
        log.info("consumer member={}", member);
        /**
         * 1.完整 url 地址：MEMBER_SERVICE_PROVIDER_URL + "/member/save" => http://localhost:10001/member/save
         * 2.member：通过 restTemplate 发出的 post 请求携带数据（对象）
         * 3.Result.class：返回对象类型
         */
        return restTemplate.postForObject(
                MEMBER_SERVICE_PROVIDER_URL + "/member/save", member, Result.class);
    }

    @GetMapping("/member/consumer/get/{id}")
    public Result<Member> queryMemberById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(
                MEMBER_SERVICE_PROVIDER_URL + "/member/get/" + id, Result.class);
    }
}
