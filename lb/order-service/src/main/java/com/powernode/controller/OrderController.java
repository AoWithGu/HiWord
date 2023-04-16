package com.powernode.controller;

import com.powernode.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class OrderController {

    @RequestMapping("/testRibbon")
    public String testRibbon(){
        System.out.println("我被调用了...02");
        return "ribbon-02";
    }


    @RequestMapping("/order")
    public String order(int userId,int goodsId){
        System.out.println("userId："+userId+", goodsId："+goodsId);
        System.out.println("正在生成订单号...");
        String orderId = UUID.randomUUID().toString();
        return orderId;
    }

    @RequestMapping("/order2")
    public String order2(int userId,int goodsId,String name,int age){
        System.out.println("userId："+userId+", goodsId："+goodsId);
        System.out.println("name："+name+", age："+age);
        System.out.println("正在生成订单号...");
        String orderId = UUID.randomUUID().toString();
        return orderId;
    }

    //请求数据如果是url上，或请求实体中的数据是这种格式：k1=v1&k2=v2 ，使用@RequestParam接受，可省略
    //请求数据是在请求实体中，在格式不确定的情况下使用@RequestBody 接受，不可省略
    //发送来的数据格式是multipart/form-data请求数据是在请求实体中，使用@RequestPart接受数据
    @RequestMapping("/order3")
    public String order3(@RequestBody User user, @RequestPart("abc") MultipartFile name){
        System.out.println("userInfo："+user);
        return "调用成功";
    }

}
