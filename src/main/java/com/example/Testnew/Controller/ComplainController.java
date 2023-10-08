package com.example.Testnew.Controller;


import com.example.Testnew.Entity.Complain;
import com.example.Testnew.Entity.Info;
import com.example.Testnew.Service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comp")
public class ComplainController {

    @Autowired
    public ComplainService complainService;

    @PostMapping("/grv")
    public Complain addComp(@RequestBody Complain complain){
        return complainService.addComp(complain);
    }

    @GetMapping("/getcmp")
    public List<Complain> getComp(){
        return complainService.getComp();
    }


}
