package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatMonthly;
import com.example.Testnew.Repository.FlatMonthlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.awt.SystemColor.text;

@Service
public class FlatMonthlyService {
    @Autowired
    private FlatMonthlyRepository flatMonthlyRepository;

    public FlatMonthly addValue(FlatMonthly flatMonthly){
        Integer monthlyMaintenance= flatMonthly.getMonthlyMaintenance();
        if (monthlyMaintenance != null) {
            return flatMonthlyRepository.save(flatMonthly);
        }
        return null;
    }
}
