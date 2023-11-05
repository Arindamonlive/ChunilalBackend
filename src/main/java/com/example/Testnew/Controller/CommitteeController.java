package com.example.Testnew.Controller;

import com.example.Testnew.Entity.Committee;
import com.example.Testnew.Entity.User;
import com.example.Testnew.Service.CommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/committee")
public class CommitteeController {
    @Autowired
    private CommitteeService committeeService;

    @PostMapping("/add")
    public Committee add(@RequestBody Committee committee){
        return committeeService.add(committee);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("userName") String username, @RequestParam("password") String password ) {


        if (committeeService.verifyCommitteeLogin(username, password)) {
            // Successful login
//            return ResponseEntity.ok("Login successful");
            return ResponseEntity.status(HttpStatus.OK).body("Login successful");
        } else {
            // Failed login
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please check the Username or Password");
        }


    }
}
