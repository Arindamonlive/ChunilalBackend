package com.example.Testnew.Service;


import com.example.Testnew.Entity.Complain;
import com.example.Testnew.Repository.ComplainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainService {
    @Autowired
    private ComplainRepo complainRepo;

    public Complain addComp(Complain complain){
        return complainRepo.save(complain);
    }

    public List<Complain> getComp(){
        return complainRepo.findAll();
    }


}
