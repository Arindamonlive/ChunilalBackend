package com.example.Testnew.Controller;


import com.example.Testnew.Entity.FlatMember;
import com.example.Testnew.Service.FlatMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/flat")
public class FlatController {

    @Autowired
    private FlatMemberService flatMemberService;

    @GetMapping("/details/{id}")
    public Optional<FlatMember> getOneFlatmember(@PathVariable("id")Long id){
        return flatMemberService.getOneFlatmember(id);
    }

    @PostMapping("/add")
    public FlatMember addMember(@RequestBody FlatMember flatMember){
        return flatMemberService.addMember(flatMember);
    }

    @PostMapping("/update/{Id}")
    public FlatMember updateMember(@PathVariable("Id")Long Id, @RequestBody FlatMember flatMember){
        return flatMemberService.updateMember(flatMember);
    }


}
