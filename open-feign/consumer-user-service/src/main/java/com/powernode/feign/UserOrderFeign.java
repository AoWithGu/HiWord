package com.powernode.feign;

import com.powernode.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("provider-order-service")
public interface UserOrderFeign {

    @GetMapping("/doOrder")
    String doOrder();

    @GetMapping("/demo01/{name}")
    String demo01(@PathVariable String name);

    @GetMapping("/demo02")
    String demo02(@RequestParam String name);

    @PostMapping("/demo03")
    String demo03(@RequestBody User user);
}
