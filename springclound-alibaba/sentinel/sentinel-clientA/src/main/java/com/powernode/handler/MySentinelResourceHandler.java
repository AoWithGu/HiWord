package com.powernode.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/3/2 14:34
 */
@Component
public class MySentinelResourceHandler {

    /**
     *1.异常处理方法必须保持和资源方法保持同样的返回值和形参列表
     * 2.形参列表最后参数是异常对象
     * 3、@SentinelResource 中配置blockhandler就是异常处理方法的名字
     **/
    public static String getInfoBlockHandler(Integer id, BlockException e){
        System.out.println(e);
        return "这是我的异常处理";
    }
}
