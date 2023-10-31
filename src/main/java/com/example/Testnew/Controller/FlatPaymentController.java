package com.example.Testnew.Controller;

import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Service.FlatPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class FlatPaymentController {
    @Autowired
    private FlatPaymentService flatPaymentService;

//    @PostMapping("/test")
//    public FlatPayment savePayment(@RequestBody FlatPayment flatPayment){
//        return flatPaymentService.saveDuesPayment(flatPayment);
//    }
    @GetMapping("/userPaymentList/{flatDetails}")
    public List<FlatPayment> getuserPaymentList(@PathVariable String flatDetails){
        return flatPaymentService.getPaymentDetailsUser(flatDetails);
    }
    @PostMapping("/test")
    public FlatPayment savePayment(@RequestBody FlatPayment flatPayment){
        return flatPaymentService.paymentTest(flatPayment);
    }
}
