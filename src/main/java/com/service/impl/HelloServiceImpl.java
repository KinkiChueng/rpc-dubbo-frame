package com.service.impl;

import com.service.IHelloService;

public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name, String msg) {
        return new StringBuffer().append("你好！").append(name).append(",").append(msg).toString();
    }
}
