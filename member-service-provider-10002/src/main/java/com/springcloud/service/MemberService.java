package com.springcloud.service;

import com.springcloud.entity.Member;

/**
 * @author XiaoZhag
 */
public interface MemberService {

    //根据 id 返回 member 数据
    Member queryMemberById(Long id);

    //添加 member
    int save(Member member);
}
