package com.powernode.controller;

import com.alibaba.fastjson.JSON;
import com.powernode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

//RestTemplate: 就是一个款HTTP客户端工具，能够发送http请求

@RestController
public class UserController {

    @RequestMapping("/doOrder")
    public String doOrder(){
        //远程调用：发送http请求
        RestTemplate restTemplate = new RestTemplate();
        String orderId = restTemplate.getForObject("http://localhost:8081/order", String.class);
        return "订单ID:"+orderId;
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getTest")
    public String getTest(){
        //getForObject(url,responseType) 发送一个http的get请求
        //url           请求的路径地址
        //responseType  返回的数据类型
        String baiduweb = restTemplate.getForObject("http://www.baidu.com", String.class);
        System.out.println(baiduweb);
        return "OK";
    }

    /**
     * 一次Http请求包含3部分内容：
     * 请求行
     *    请求方式   请求资源路径   协议版本
     * 请求头
     * 请求实体
     *
     * 一次Http响应包含3部分内容：
     * 状态行
     *    协议版本   状态码   状态码的描述
     * 应答头/响应头
     * 响应实体
     */

    @RequestMapping("/getTest2")
    public String getTest2(){
        //getForEntity(url,responseType) 发送一个http的get请求
        //url           请求的路径地址
        //responseType  返回的数据类型
        //返回值：ResponseEntity表示一个响应对象
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8081/order", String.class);

//        entity.getStatusCode().getReasonPhrase(); //获取Http状态码
        //entity.getStatusCodeValue()  //获取状态码
        HttpHeaders headers = entity.getHeaders(); //headers 就是应答头
        String body = entity.getBody(); // body响应体

        return "OK";
    }

    @RequestMapping("/getTest3")
    public String getTest3(){
        //get请求发送参数只需要放在url后面即可，以“?k1=v1&k2=v2”的格式附加在url的后面即可
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8081/order?userId=1&goodsId=18", String.class);
        return "OK";
    }

    @RequestMapping("/postTest")
    public String postTest(){
//        postForObject(url,request,responseType) //发送Http的Post请求，post请求除了请求传参数之外，也可以url传参
        //url – 请求的地址
        //request – 请求实体
        //responseType – 返回类型
        String url = "http://localhost:8081/order2?userId=1&goodsId=18";
        LinkedMultiValueMap map = new LinkedMultiValueMap();
        map.add("name", "老王");
        map.add("age",34);
        String orderId = restTemplate.postForObject(url, map, String.class);
        return "订单ID:"+orderId;
    }


    @RequestMapping("/postTest2")
    public String postTest2(){
        String url = "http://localhost:8081/order3";
        User user = new User();
        user.setName("cxs");
        user.setAge(18);
        user.setHobby("编码");

        String result = restTemplate.postForObject(url, user, String.class);
        System.out.println(result);
        return "OK";
    }

    @Autowired
    private DiscoveryClient discoveryClient;

//    private int num = 0;

//    @RequestMapping("/testlb")
//    public String testlb(String appName){
//        List<ServiceInstance> instances = discoveryClient.getInstances(appName);
//        //通过instances获取要调用机器的ip+port
////        Random random = new Random();
////        int i = random.nextInt(instances.size());
//        int serviceIndex = ++num % instances.size();
//        if (num == Integer.MAX_VALUE){
//            num = 0;
//        }
//        ServiceInstance serviceInstance = instances.get(serviceIndex);
//        String protocolPre = "http://";
//        String ip = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        String url = protocolPre+ip+":"+port+"/testRibbon";
//
//        String result = restTemplate.getForObject(url, String.class);
//        return result;
//    }


    @RequestMapping("/testlb")
    public String testlb(String appName){
        String url = "http://" + "ORDER-SERVICE" + "/testRibbon";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

}
