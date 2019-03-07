package com.wbb.serviceribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wbb.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @Override
    public String sayHello(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name="+name,String.class);//使用ribbon实现负载均衡的时候，服务名称不能用下划线，换成中划线。
    }

    public String error(String name){
        return "sorry "+ name +",ribbon error";
    }
}
