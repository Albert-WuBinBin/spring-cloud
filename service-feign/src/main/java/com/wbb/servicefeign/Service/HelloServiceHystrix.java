package com.wbb.servicefeign.Service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceHystrix implements  HelloService{
    @Override
    public String sayHello(String name) {
        return "sorry "+ name +",error";
    }
}
