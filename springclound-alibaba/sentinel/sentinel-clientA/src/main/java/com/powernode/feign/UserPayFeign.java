package com.powernode.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("sentinel-clientB-provider")
public interface UserPayFeign {

    @RequestMapping("/pay")
    String pay(@RequestParam Integer orderId);
}
