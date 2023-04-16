package com.powernode.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/3/2 11:13
 */
@Component
public class MyBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {

        response.setContentType("application/json;charset=utf-8");
//        设置状态码
        response.setStatus(429);

        Map<String,Object> result = new HashMap<>(4);
        result.put("code",-1);
        if(e instanceof FlowException){
            result.put("msg","您被流控了。。");
        }else if(e instanceof DegradeException){
            result.put("msg","网络异常");
        }else{
            result.put("msg","出现未知错误");
        }
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(result);
//        给用户返回信息
        PrintWriter writer = response.getWriter();
        writer.print(s);
    }
}
