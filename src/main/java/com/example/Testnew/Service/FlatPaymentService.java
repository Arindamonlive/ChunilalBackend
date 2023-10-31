package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatDetails;
import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Repository.FlatPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatPaymentService {
    @Autowired
    private FlatPaymentRepository flatPaymentRepository;
    @Autowired
    private FlatDetailsService flatDetailsService;



//    public FlatPayment saveFlatPayment(FlatPayment flatPayment){
//        return flatPaymentRepository.save(flatPayment);
//    }

    public FlatPayment saveDuesPayment(FlatPayment flatPayment){
        return flatPaymentRepository.save(flatPayment);
    }
    public List<FlatPayment> getPaymentDetailsUser(String flatDetails){
        return flatPaymentRepository.findByFlatDetails(flatDetails);
    }
    public FlatPayment paymentTest(FlatPayment flatPayment){
        if(flatPayment.getDues() == null){
            return flatPaymentRepository.save(flatPayment);
        } else {
            flatDetailsService.updateDues(flatPayment.getFlatDetails());
            flatPaymentRepository.save(flatPayment);
        }
        return flatPayment;
    }

}
