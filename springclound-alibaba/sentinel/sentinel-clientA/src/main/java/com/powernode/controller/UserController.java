package com.powernode.controller;

import com.powernode.feign.UserPayFeign;
import com.powernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/3/2 10:10
 */
@RestController
public class UserController {

    @RequestMapping("/info")
    public String Info(){
        return "qaq";
    }


//    线程快速失败测试
    @RequestMapping("/demo1")
    public String demo1(){

        try {

            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "111";
    }
    @RequestMapping("/demo2")
    public String demo2(){

        return "222";
    }
    @RequestMapping("/demo3")
    public String demo3(){

        System.out.println(LocalDateTime.now().toLocalTime());
        return "333";
    }

//    链路测试

    @Autowired
    private UserService userService;


    @RequestMapping("/testLink1")
    public String testLink1(){
        String info = userService.getInfo(1);
        return info;
    }
    @RequestMapping("/testLink2")
    public String testLink2(){
        String info = userService.getInfo(2);
        return info;
    }

//    degrade 熔断策略
//      慢调用比例
    @RequestMapping("/demo4")
    public String demo4(){
        try {
            TimeUnit.SECONDS.sleep(1);
            return "444";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "???";

    }

//    异常策略
    @RequestMapping("/demo5")
    public String demo5(){
        int i  = 10/0;
        return "555";
    }
    @Autowired
    private UserPayFeign userPayFeign;

    @RequestMapping("/doPay")
    public String doPay(){
        String pay = userPayFeign.pay(10);
        return pay;
    }
    



}
