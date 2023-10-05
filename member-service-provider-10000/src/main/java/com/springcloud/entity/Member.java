package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XiaoZhag
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String pwd;
    private String mobile;
    private String email;
    private Integer gender;
}
