package com.amorsl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderZkController {
    @Autowired
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/zk")
    public String paymentInfo(){
        String res = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return res;
    }
}
