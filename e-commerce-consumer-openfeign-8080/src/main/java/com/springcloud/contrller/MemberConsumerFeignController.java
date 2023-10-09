package com.springcloud.contrller;

import com.springcloud.entity.Result;
import com.springcloud.service.MemberFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XiaoZhag
 */
@RestController
public class MemberConsumerFeignController {

    //装配 MemberFeignService
    @Resource
    private MemberFeignService memberFeignService;

    @GetMapping("/member/consumer/openfeign/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id){
        return memberFeignService.queryMemberById(id);
    }
}
