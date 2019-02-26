package com.wbb.servicefeign.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", fallback = HelloServiceHystrix.class)
public interface HelloService {
    @GetMapping("/hello")
    String sayHello(@RequestParam("name") String name);
}
