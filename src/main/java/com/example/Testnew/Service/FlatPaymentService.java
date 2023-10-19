package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatMonthly;
import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Repository.FlatPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatPaymentService {
    @Autowired
    private FlatPaymentRepository flatPaymentRepository;

    public FlatPayment saveFlatPayment(FlatPayment flatPayment){
        return flatPaymentRepository.save(flatPayment);
    }

//    public FlatPayment saveDuesPayment(FlatPayment flatDetails, double dues){
//        return flatPaymentRepository.save(flatDetails,dues);
//    }

}
