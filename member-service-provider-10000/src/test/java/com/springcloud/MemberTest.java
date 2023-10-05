package com.springcloud;

import com.springcloud.dao.MemberDao;
import com.springcloud.entity.Member;
import com.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author XiaoZhag
 */
@SpringBootTest
@Slf4j
public class MemberTest {

    //装配 MemberDao
    @Resource
    private MemberDao memberDao;

    @Resource
    private MemberService memberService;

    //这里的 @Test 是引用 org.junit.jupiter.api.Test
    @Test
    public void queryMemberByIdTest(){
//        Member member = memberDao.queryMemberById(1L);
        Member member = memberService.queryMemberById(2L);
        log.info("member={}", member);
    }

    @Test
    public void saveTest(){
        Member member = new Member(null, "lucy", "123456", "12345678909", "lucy@qq.com", 2);
        System.out.println(memberService.save(member));
//        System.out.println(memberDao.save(member));
    }
}
