package com.example.Testnew.Controller;


import com.example.Testnew.Entity.Complain;
import com.example.Testnew.Entity.Info;
import com.example.Testnew.Service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @PostMapping("/wtu")
    public Info addInfo(@RequestBody Info info){
        return infoService.addInfo(info);
    }

    @GetMapping("/getwtu")
    public List<Info> getInfo(){
        return infoService.getInfo();
    }


}
