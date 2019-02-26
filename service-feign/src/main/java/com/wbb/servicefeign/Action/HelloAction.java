package com.wbb.servicefeign.Action;

import com.wbb.servicefeign.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAction {
    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name){
        return helloService.sayHello(name);
    }
}
