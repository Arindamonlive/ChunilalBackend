package com.example.Testnew.Controller;

import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Service.FlatPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class FlatPaymentController {
    @Autowired
    private FlatPaymentService flatPaymentService;

//    @PostMapping("/test")
//    public FlatPayment saveDuesPayment(@RequestBody FlatPayment flatDetails, double dues){
//        return flatPaymentService.saveDuesPayment(flatDetails,dues);
//    }
}
