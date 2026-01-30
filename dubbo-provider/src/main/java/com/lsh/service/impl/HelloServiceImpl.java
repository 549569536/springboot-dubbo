package com.lsh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lsh.dto.User;
import com.lsh.service.HelloService;

import java.util.concurrent.TimeUnit;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        System.out.println("Dubbo-Provider!");
        return "Dubbo-Provider Hello World!";
    }

    @Override
    public void hTest1(String name, int age) {
        System.out.println(name + " " + age);
    }

    @Override
    public void hTest2(User user) {
        System.out.println(user.getName() + " " + user.getAge());
    }
}
