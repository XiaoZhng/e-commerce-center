package com.springcloud.controller;

import com.springcloud.entity.Member;
import com.springcloud.entity.Result;
import com.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author XiaoZhag
 */
@RestController
@Slf4j
public class MemberController {

    @Resource
    private MemberService memberService;

    /**
     * 1.前端如果是以 json 格式来发送添加信息 Member，那么需要使用 @RequestBody,
     * 才能将数据封装到对应的 bean，同时保证 http 的请求头的 content-type 是对应的
     * 2.如果前端是以表单形式提交，则不需要使用 @RequestBody，才会进行对象参数封装，同时保证
     * http 的请求头的 content-type 是对应的
     */
    @PostMapping("/member/save")
    public Result save(@RequestBody Member member){
        log.info("provider member={}", member);
        int result = memberService.save(member);
        if (result > 0){
            return Result.success(member, "添加成功");
        }else {
            return Result.error("401", "添加失败");
        }
    }

    @GetMapping("/member/get/{id}")
    public Result queryMemberById(@PathVariable("id") Long  id){

//        //模拟超时，休眠 5s
//        try {
//            TimeUnit.MILLISECONDS.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Member member = memberService.queryMemberById(id);
        if (member != null){
            return Result.success(member, "查询成功,member-service-provider-10000");
        }else {
            return Result.error("401", "id = " + id + "的信息不存在");
        }
    }
}
