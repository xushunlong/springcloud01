package com.amorsl.springcloud.service;

import com.amorsl.springcloud.service.hytrix.OrderDefaultService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderDefaultService.class)
public interface OrderHytrixService {
    @GetMapping("/payment/hytrix/ok/{id}")
    String paymentHytrix_Ok(@PathVariable("id") Integer id) ;

    @GetMapping("/payment/hytrix/timeout/{id}")
    String paymentHytrix_Timeout(@PathVariable("id") Integer id) ;
}
