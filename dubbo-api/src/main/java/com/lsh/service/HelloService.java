package com.lsh.service;

import com.lsh.dto.User;

public interface HelloService {

    String hello();

    void hTest1(String name, int age);

    void hTest2(User user);
}
