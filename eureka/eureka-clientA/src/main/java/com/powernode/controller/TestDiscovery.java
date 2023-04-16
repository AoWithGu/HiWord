package com.powernode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class TestDiscovery {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    public String getInstance(String appName){
        //我们希望调用B服务器的接口，我们需要B机器的IP和端口号
        //A服务器就可以通过服务发现来获取B机器的相关信息
        List<ServiceInstance> instances = discoveryClient.getInstances(appName);

        if (instances != null && instances.size() > 0){
            Random random = new Random();
            int i = random.nextInt(instances.size());

            ServiceInstance serviceInstance = instances.get(i);
            return serviceInstance.toString();
        }
        return null;
    }

}
