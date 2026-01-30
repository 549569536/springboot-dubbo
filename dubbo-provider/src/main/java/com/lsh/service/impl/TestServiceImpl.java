package com.lsh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lsh.dto.User;
import com.lsh.service.TestService;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test1() {
        return "Dubbo-Provider!";
    }

    @Override
    public void test2(String name) {
        System.out.println(name);
    }

    @Override
    public String test3(User user) {
        return user.getName() + " " + user.getAge();
    }

    @Override
    public User test4(User user) {
        return user;
    }
}
