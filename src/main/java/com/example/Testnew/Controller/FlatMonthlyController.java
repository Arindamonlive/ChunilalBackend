package com.example.Testnew.Controller;
import com.example.Testnew.Entity.FlatMonthly;
import com.example.Testnew.Service.FlatMonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monthly")
public class FlatMonthlyController {
    @Autowired
    private FlatMonthlyService flatMonthlyService;

    @PostMapping("/amount")
    public FlatMonthly addValue(@RequestBody FlatMonthly flatMonthly){
        return flatMonthlyService.addValue(flatMonthly);
    }
//    @PostMapping("/newamount")
//    public FlatMonthly saveMonthly(@PathVariable FlatMonthly flatMonthly){
//        return flatMonthlyService.saveMonthly(flatMonthly);
//    }

}
