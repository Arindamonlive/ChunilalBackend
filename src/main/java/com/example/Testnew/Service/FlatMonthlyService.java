package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatMonthly;
import com.example.Testnew.Repository.FlatMonthlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatMonthlyService {
    @Autowired
    private FlatMonthlyRepository flatMonthlyRepository;

    public FlatMonthly saveMonthly(FlatMonthly flatMonthly){
        return flatMonthlyRepository.save(flatMonthly);
    }
}
