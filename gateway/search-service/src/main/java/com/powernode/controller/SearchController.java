package com.powernode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/2/25 11:01
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @RequestMapping("/search")
    public String productSearch(String keyworks){
        return "查询的商品...";
    }

    @RequestMapping("/search2")
    public String productSearch2(String keyworks){
        return "查询的商品2...";
    }
}
