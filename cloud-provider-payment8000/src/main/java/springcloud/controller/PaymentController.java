package springcloud.controller;

import com.amorsl.springcloud.entities.CommonResult;
import com.amorsl.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int res = paymentService.create(payment);
        if (res > 0) {
            return new CommonResult(200, "success,port at" + serverPort, payment);
        } else {
            return new CommonResult(444, "failed,port at" + serverPort, null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "success,port at" + serverPort, payment);
        } else {
            return new CommonResult(444, "failed,port at" + serverPort, null);
        }
    }

    @GetMapping("/discovery")
    public Object getDiscovery() {
         List<String> services = discoveryClient.getServices();
         for (String s:services){
             log.error("************,service "+s);
         }
         return discoveryClient.getInstances("cloud-payment-service");
    }

    @GetMapping("/timeout")
    public String getLongTimeServer() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }
}
