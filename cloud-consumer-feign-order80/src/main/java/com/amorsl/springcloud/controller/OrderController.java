package com.amorsl.springcloud.controller;

import com.amorsl.springcloud.entities.CommonResult;
import com.amorsl.springcloud.entities.Payment;
import com.amorsl.springcloud.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {
    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return orderFeignService.getPaymentById(id);
    }

    @GetMapping("/timeout")
    public CommonResult<String> getTimeOut() {
        return new CommonResult<String>(200, orderFeignService.getLongTimeServer());
    }
}
