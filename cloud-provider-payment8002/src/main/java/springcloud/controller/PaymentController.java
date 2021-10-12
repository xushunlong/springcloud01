package springcloud.controller;

import com.amorsl.springcloud.entities.CommonResult;
import com.amorsl.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

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

    @GetMapping("/timeout")
    public String getLongTimeServer() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }

}
