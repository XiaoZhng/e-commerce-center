package com.springcloud.controller;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author XiaoZhag
 */
@Component
public class CustomUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String originUrl) {
        //isBlank方法就是判断 originUrl != null && 有长度 && originUrl 不全部为空格
        if (StringUtils.isBlank(originUrl)){
            return originUrl;
        }
        if (originUrl.startsWith("/member/get")){
            /**
             * 1.如果请求的是接口 /member/get 开头的，比如 /member/get/1
             * 2.给 Sentinel 的返回的资源名就是 /member/get/*
             * 3.在 Sentinel 对 /member/get/* 添加流控规则即可
             */
            return "/member/get/*";
        }
        return originUrl;
    }
}
