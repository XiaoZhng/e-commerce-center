package com.springcloud.controller;

import com.springcloud.entity.Member;
import com.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author XiaoZhag
 */
@RestController
@Slf4j
public class MemberConsumerController {

    //定义 MEMBER_SERVICE_PROVIDER_URL 基础 url 地址
    //shift + ctrl + U：大小写切换
    public static final String MEMBER_SERVICE_PROVIDER_URL =
            "http://localhost:10001";

    //装配 RestTemplate
    @Resource
    private RestTemplate restTemplate;

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
