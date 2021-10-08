package springcloud.controller;

import com.amorsl.springcloud.entities.CommonResult;
import com.amorsl.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int res = paymentService.create(payment);
        if (res > 0) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "failed", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "failed", null);
        }
    }

}
