package com.powernode.controller;

import com.powernode.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/2/23 14:51
 */
@RestController
public class OrderController {

    /**
     * 订单服务下单接口
     *
     */
    @GetMapping("/doOrder")
    public String doOrder() {
        System.out.println("有用户来下单了");
        return "下单成功";
    }

    @GetMapping("/demo01/{name}")
    public String demo01(@PathVariable String name) {
        System.out.println("demo01");
        return "demo01";
    }


    @GetMapping("/demo02")
    public String demo02(String name) {
        System.out.println(name);
        System.out.println("demo02");
        return "demo02";
    }

    @PostMapping("/demo03")
    public String demo03(@RequestBody User user) {
        System.out.println(user);
        System.out.println("demo03");
        return "demo03";
    }

}
