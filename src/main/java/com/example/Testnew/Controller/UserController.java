package com.example.Testnew.Controller;


import com.example.Testnew.Entity.User;
import com.example.Testnew.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
       return userService.getAllUser();
    }

    @GetMapping("/getOneUser/{id}")
    public User getOneUser(@PathVariable("id") Long id){
        return userService.getOneUser(id);
    }

    @GetMapping("/getOneUserByPhone/{phoneNumber}")
    public Optional<User> getOneUserByPhoneNumber(@PathVariable("phoneNumber")String phoneNumber){
        return userService.getOneUserByPhonenumber(phoneNumber);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @PostMapping("/update/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/phonenumber/{id}")
    public Optional<User> getPhoneNumber(@PathVariable("id")Long id){
        return userService.getPhoneNumber(id);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
//        String phoneNumber = loginData.get("username");
//        String password = loginData.get("password");
//
//        if (userService.verifyLogin(phoneNumber, password)) {
//            // Successful login
////            return ResponseEntity.ok("Login successful");
//            return ResponseEntity.status(HttpStatus.OK).body(phoneNumber);
//        } else {
//            // Failed login
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
//        }
//
//
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username,@RequestParam("password") String password ) {


        if (userService.verifyLogin(username, password)) {
            // Successful login
//            return ResponseEntity.ok("Login successful");
            return ResponseEntity.status(HttpStatus.OK).body("Login param successful");
        } else {
            // Failed login
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login param failed");
        }


    }

//    @PostMapping("/login/{username}&{password}")
//    public ResponseEntity<String> login(@PathVariable("username") String username,@PathVariable("password") String password ) {
//
//
//        if (userService.verifyLogin(username, password)) {
//            // Successful login
//            return ResponseEntity.ok("Login successful");
//        } else {
//            // Failed login
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
//        }


//    }

}
