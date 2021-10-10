package com.amorsl.springcloud.controller;

import com.amorsl.springcloud.entities.CommonResult;
import com.amorsl.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    private static final String URL_PREFIX = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(URL_PREFIX + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL_PREFIX + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/getEntities/{id}")
    public CommonResult getPaymentEntities(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> res = restTemplate.getForEntity(URL_PREFIX + "/payment/get/" + id, CommonResult.class);
        if (res.getStatusCode().is2xxSuccessful()) {
            return res.getBody();
        } else
            return new CommonResult(444, "error");
    }

}
