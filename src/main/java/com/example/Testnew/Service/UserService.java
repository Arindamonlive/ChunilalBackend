package com.example.Testnew.Service;


import com.example.Testnew.Entity.User;
import com.example.Testnew.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getOneUser(Long id){
        return userRepo.findById(id).orElseThrow();
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }

    public User updateUser(Long id, User user){
        return userRepo.save(user);
    }

    public boolean verifyLogin(String phoneNumber, String password) {
        Optional<User> userOptional = userRepo.findByPhoneNumber(phoneNumber);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String storedPassword = user.getPassword();

            if (yourPasswordVerificationMethod(password, storedPassword)) {
                return true;
            }
        }

        return false;
    }

    public Optional<User> getPhoneNumber(Long id){
        return userRepo.findById(id);
    }
    private boolean yourPasswordVerificationMethod(String inputPassword, String storedPassword) {
        return inputPassword.equals(storedPassword);
    }

}
