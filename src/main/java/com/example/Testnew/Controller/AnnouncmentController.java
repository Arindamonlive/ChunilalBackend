package com.example.Testnew.Controller;

import com.example.Testnew.Entity.Announcement;
import com.example.Testnew.Entity.Complain;
import com.example.Testnew.Service.AnnouncmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ann")
public class AnnouncmentController {
    @Autowired
    public AnnouncmentService announcmentService;

    @PostMapping("/add")
    public Announcement addAnn(@RequestBody Announcement announcement){
        return announcmentService.addAnn(announcement);
    }

    @GetMapping("/getann")
    public List<Announcement> getAnn(){ return announcmentService.getAnn();}


}
