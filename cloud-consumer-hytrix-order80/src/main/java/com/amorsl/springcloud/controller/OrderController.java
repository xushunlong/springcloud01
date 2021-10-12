package com.amorsl.springcloud.controller;

import com.amorsl.springcloud.service.OrderHytrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@DefaultProperties(defaultFallback = "paymentGolbalHandler")
@RequestMapping("/consumer/payment/hytrix")
public class OrderController {
    @Autowired
    private OrderHytrixService orderHytrixService;

    @GetMapping("/ok/{id}")
    public String paymentHytrix_Ok(@PathVariable("id") Integer id) {
        return orderHytrixService.paymentHytrix_Ok(id);
    }

    @GetMapping("/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_Handler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @HystrixCommand
    public String paymentHytrix_Timeout(@PathVariable("id") Integer id) {
        int i = 10/0;
        return orderHytrixService.paymentHytrix_Timeout(id);
    }

    public String paymentInfo_Handler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentinfo_Timeout,执行默认方法";
    }

    public String paymentGolbalHandler(){
        return "全局默认方法";
    }

}
