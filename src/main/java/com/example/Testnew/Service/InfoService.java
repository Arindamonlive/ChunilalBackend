package com.example.Testnew.Service;


import com.example.Testnew.Entity.Complain;
import com.example.Testnew.Entity.Info;
import com.example.Testnew.Repository.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepo infoRepo;

    public Info addInfo(Info info){
        return infoRepo.save(info);
    }

    public List<Info> getInfo(){
        return infoRepo.findAll();
    }


}
