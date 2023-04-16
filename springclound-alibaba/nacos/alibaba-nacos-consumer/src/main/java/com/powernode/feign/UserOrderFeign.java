package com.powernode.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("alibaba-nacos-provider")
public interface UserOrderFeign {

    @RequestMapping("/doOrder")
    String doOrder();

}
