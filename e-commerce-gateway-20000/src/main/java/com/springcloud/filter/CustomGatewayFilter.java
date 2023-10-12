package com.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author XiaoZhag
 * 自定义全局 GlobalFilter 过滤
 */
//@Component
public class CustomGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("----CustomGatewayFilter----");
        String user = exchange.getRequest().getQueryParams().getFirst("user");
        String pwd = exchange.getRequest().getQueryParams().getFirst("pwd");
        if (!("jack".equals(user) && "123".equals(pwd))){
            System.out.println("----非法用户----");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE); //回应 406
            return exchange.getResponse().setComplete();
        }
        //验证通过，放行
        return chain.filter(exchange);
    }

    /**
     * order：表示该过滤器执行的顺序，数字越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
