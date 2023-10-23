package com.example.Testnew.Controller;

import com.example.Testnew.Entity.FlatDetails;
import com.example.Testnew.Repository.FlatDetailsRepository;
import com.example.Testnew.Service.FlatDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flat-details")
public class FlatDetailsController {

    @Autowired
    private FlatDetailsService flatDetailsService;

    private FlatDetailsRepository flatDetailsRepository;

    @PostMapping("/addAmount")
    public FlatDetails addAmount(@RequestBody FlatDetails flatDetails) {
        return flatDetailsService.addAmount(flatDetails);
    }

//    @PostMapping("/pay")
//    public FlatDetails payMonthlyAmount(@RequestParam String flatDetails, @RequestParam double payment) {
//        return flatDetailsService.payMonthlyAmount(flatDetails, payment);
//    }

    @GetMapping("/{flatDetails}")
    public FlatDetails getFlatDetails(@PathVariable String flatDetails) {
        return flatDetailsRepository.findByFlatDetails(flatDetails);
    }
}

