package com.powernode.controller;

import com.powernode.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserOrderFeign userOrderFeign;

    @RequestMapping("/userDoOrder")
    public String userDoOrder(){
        String orderSn = userOrderFeign.doOrder();
        return "下单成功，订单号为："+orderSn;
    }

}
