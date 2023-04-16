package com.powernode.globalfilter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//只有有路由，就会运行这个全局过滤器
//@Component
public class MyFirstGlobalFilter implements GlobalFilter, Ordered {

//    Filter
//    public void doFilter(HttpServletRequest req,HttpServletResponse resp,FilterChain chain){
//      chain.doFilter(req,resp,chain)
//    }
//    不是tomcat中的那个过滤器了,而是netty

    /**
     *
     * @param exchange 表示一个请求和一次响应对象的集合
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        System.out.println("过滤器运行了...");

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
