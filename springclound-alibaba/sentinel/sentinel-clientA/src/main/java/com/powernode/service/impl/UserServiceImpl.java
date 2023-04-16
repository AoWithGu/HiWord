package com.powernode.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.powernode.handler.MySentinelResourceHandler;
import com.powernode.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/3/2 14:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    @SentinelResource(value = "getInfo",blockHandler = "getInfoBlockHandler",blockHandlerClass = MySentinelResourceHandler.class)
    public String getInfo(Integer id) {
        return "用户:"+id;
    }

}
