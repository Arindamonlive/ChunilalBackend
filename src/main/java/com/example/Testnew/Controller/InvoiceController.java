package com.example.Testnew.Controller;

import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

//    @PostMapping("/generate/{id}")
//    public FlatPayment generateInvoice(@PathVariable Long id){
//        return invoiceService.generateInvoice(id);
//    }

    @PostMapping("/download/{id}")
    public byte[] downloadInvoice(@PathVariable Long id){
        return invoiceService.generateNewInvoice(id);
    }

//    @PostMapping("/generate/{id}")
//    public ResponseEntity<byte[]> generateInvoice(@PathVariable Long id){
//        return invoiceService.generateInvoice(id);
//    }
    @GetMapping("/allfm/{flatDetails}")
    public List<FlatPayment> getFmPaymentDetails(@PathVariable String flatDetails){
        return invoiceService.getFmPaymentDetails(flatDetails);
    }
}
