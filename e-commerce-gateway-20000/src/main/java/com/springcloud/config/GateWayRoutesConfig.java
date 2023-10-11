package com.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoZhag
 */
//@Configuration
public class GateWayRoutesConfig {

    @Bean
    public RouteLocator myGateWayRoutesConfig01(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("member_routh03", r -> r.path("/member/get/**").uri("http://localhost:10000")).build();
    }

    @Bean
    public RouteLocator myGateWayRoutesConfig02(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("member_routh04", r -> r.path("/member/save").uri("http://localhost:10000")).build();
    }
}
