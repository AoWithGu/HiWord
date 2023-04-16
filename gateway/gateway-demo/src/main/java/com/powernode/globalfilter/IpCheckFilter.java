package com.powernode.globalfilter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/2/25 16:56
 */
@Component
public class IpCheckFilter implements GlobalFilter {

    List<String> blackList = Arrays.asList("192.168.1.131","localhost");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String hostName = Objects.requireNonNull(request.getRemoteAddress()).getHostName();

        if(!blackList.contains(hostName)){
            return chain.filter(exchange);
        }
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().set("content-type","text/plain;charset=utf-8");
        String msg ="你在黑名单中";
        DataBuffer wrap = response.bufferFactory().wrap(msg.getBytes());
        return response.writeWith(Mono.just(wrap));
    }
}
