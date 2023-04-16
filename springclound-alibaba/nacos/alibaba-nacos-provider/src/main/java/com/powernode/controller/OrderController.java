package com.powernode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {


    @RequestMapping("/doOrder")
    public String doOrder(){
        System.out.println("有人来下订单了，返回订单号！");
        return UUID.randomUUID().toString().replace("-", "");
    }

}
