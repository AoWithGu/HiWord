package com.powernode.controller;

import com.powernode.feign.UserOrderFeign;
import com.powernode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/2/23 14:51
 */
@RestController
public class UserController {
    /**
     *  1.创建一个 com.powernode.feign.UserOrderFeign接口
     *  2.从生产者那边拷贝我们要调用的接口的方法签名
     *  3.给接口添加一个@FeignClient("生产者appName") 注解的value值为生产者appName
     *  4.在消费者那一端使用@Autowired注解注入一个UserOrderFeign接口
     *  5.在消费者启动类上添加@EnableFeignClients
     */

    @Autowired
    private UserOrderFeign userOrderFeign;


    @GetMapping("/testDemo01")
    public String testDemo01(){
        String hello = userOrderFeign.demo01("hello");
        return hello;
    }

    @GetMapping("/testDemo02")
    public String testDemo02(){
        String hehe = userOrderFeign.demo02("hehe");
        return hehe;
    }

    @PostMapping("/testDemo03")
    public String testDemo03(){
        User user = new User("laowang",34,"ctrl");
        String hehe = userOrderFeign.demo03(user);
        return hehe;
    }



    @GetMapping("/userDoOrder")
    public String userDoOrder() {
        //我们之前是通过RestTemplate + ribbon +eureka的服务发现 来完成的远程调用
        //接下来，我们使用openfeign来完成该实现！
        String s = userOrderFeign.doOrder();
        return s;

//        ClassLoader classLoader = UserOrderFeign.class.getClassLoader();
//
//        UserOrderFeign userOrderFeign = (UserOrderFeign) Proxy.newProxyInstance(
//                classLoader, new Class[]{UserOrderFeign.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                System.out.println(method.getName());
//                GetMapping annotation = method.getAnnotation(GetMapping.class);
//                String path = annotation.value()[0];
//                Class<?> declaringClass = method.getDeclaringClass();
//                FeignClient feignClient = declaringClass.getAnnotation(FeignClient.class);
//                String appName = feignClient.value();
//
//                return "ok";
//            }
//        });
//        return null;
    }
}
