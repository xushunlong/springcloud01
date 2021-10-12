package com.amorsl.springcloud.controller;

import com.amorsl.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/hytrix")
public class OrderHystrixController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/ok/{id}")
    public String paymentHytrix_Ok(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_Ok(id);
    }

    @GetMapping("/timeout/{id}")
    public String paymentHytrix_Timeout(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_TimeOut(id);
    }


}
