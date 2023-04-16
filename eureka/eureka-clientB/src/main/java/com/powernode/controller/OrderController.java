package com.powernode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/orders")
    public String orderDetail(int userId){
        System.out.println("查询数据库，获取订单信息");
        return "订单信息!";
    }

}
