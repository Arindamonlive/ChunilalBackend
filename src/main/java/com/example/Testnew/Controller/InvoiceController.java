package com.example.Testnew.Controller;

import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/generate")
    public FlatPayment generateInvoice(@RequestBody FlatPayment flatPayment){
        return invoiceService.generateInvoice(flatPayment);
    }
}
