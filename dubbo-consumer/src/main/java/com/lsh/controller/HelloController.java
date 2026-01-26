package com.lsh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lsh.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Dubbo-Customer");
        return helloService.hello();
    }
}
