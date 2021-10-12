package com.amorsl.springcloud.service.hytrix;

import com.amorsl.springcloud.service.OrderHytrixService;
import org.springframework.stereotype.Service;

@Service
public class OrderDefaultService implements OrderHytrixService {
    @Override
    public String paymentHytrix_Ok(Integer id) {
        return "default paymentHytrix_Ok";
    }

    @Override
    public String paymentHytrix_Timeout(Integer id) {
        return "default paymentHytrix_Timeout";
    }
}
