package com.lsh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lsh.service.HelloService;

import java.util.concurrent.TimeUnit;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        System.out.println("Dubbo-Provider!");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "Dubbo-Provider Hello World!";
    }
}
