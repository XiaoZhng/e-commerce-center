package com.springcloud.controller;

import com.springcloud.entity.Member;
import com.springcloud.entity.Result;
import com.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author XiaoZhag
 */
@RestController
@Slf4j
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/t1")
    public Result t1(){
        return Result.success("t1()...");
    }

    @GetMapping("/t2")
    public Result t2(){
        try{
            //让线程休眠 1s, 模拟执行时间
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("正在执行t2(),线程id= " + Thread.currentThread().getId());
        return Result.success("t2()...");
    }

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
//    @GetMapping(value = "/member/get", params = "id")
//        public Result queryMemberById(Long id){
        Member member = memberService.queryMemberById(id);
        try {
            //让线程休眠 1s，模拟执行时间
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("当前的线程id= " + Thread.currentThread().getId() + ",时间= " + new Date());
        if (member != null){
            return Result.success(member, "查询成功,member-service-nacos-provider-10004");
        }else {
            return Result.error("401", "id = " + id + "的信息不存在");
        }
    }
}
