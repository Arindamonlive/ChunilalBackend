package com.example.Testnew.Service;

import com.example.Testnew.Entity.Committee;
import com.example.Testnew.Entity.User;
import com.example.Testnew.Repository.CommitteeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommitteeService {
    @Autowired
    private CommitteeRepo committeeRepo;

    public Committee add(Committee committee){ return committeeRepo.save(committee);}

    public boolean verifyCommitteeLogin(String userName,String password){
        Optional<Committee> committeeOptional=committeeRepo.findByUserName(userName);
        if(committeeOptional.isPresent()) {
            Committee committee = committeeOptional.get();
            String storedPassword = committee.getPassword();
            if (passwordVerification(password, storedPassword)) {
                return true;
            }
        }
    return false;
    }

    private boolean passwordVerification(String inputPassword, String storedPassword) {
        return inputPassword.equals(storedPassword);
    }
}
