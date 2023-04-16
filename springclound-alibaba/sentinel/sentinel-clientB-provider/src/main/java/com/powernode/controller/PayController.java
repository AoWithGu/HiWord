package com.powernode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/3/2 16:43
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @RequestMapping("/pay")
    public String pay(@RequestParam Integer orderId){
        return "购买:"+orderId;
    }
}
