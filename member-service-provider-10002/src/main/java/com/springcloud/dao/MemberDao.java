package com.springcloud.dao;

import com.springcloud.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author XiaoZhag
 */
@Mapper
public interface MemberDao {

    //根据 id 返回 member 数据
    Member queryMemberById(Long id);

    //添加 member
    int save(Member member);
}
