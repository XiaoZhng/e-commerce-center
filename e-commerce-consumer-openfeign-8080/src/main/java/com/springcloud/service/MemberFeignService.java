package com.springcloud.service;

import com.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author XiaoZhag
 */
@Component
@FeignClient(value = "MEMBER-SERVICE-PROVIDER")
public interface MemberFeignService {

    /**
     * 1.远程调用的方式为 get
     * 2.远程调用的 url 为 http://MEMBER-SERVICE-PROVIDER/member/get/{id}
     * 3.MEMBER-SERVICE-PROVIDER 就是 Eureka Server 服务提供方注册的名称
     * 4.Openfeign 会根据负载均衡来决定调用 10000/10002-默认是轮询
     * 5.因为 Openfeign 好处是支持了 springmvc 注解 + 接口解耦
     */
    //定义接口
    @GetMapping("/member/get/{id}")
    public Result queryMemberById(@PathVariable("id") Long  id);
}
