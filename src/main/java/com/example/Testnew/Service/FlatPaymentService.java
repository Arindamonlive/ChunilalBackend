package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatDetails;
import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Repository.FlatPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        Date todayDate=new Date();
        List<FlatPayment> previousPayments = flatPaymentRepository.findByFlatDetails(flatPayment.getFlatDetails());
        if(flatPayment.getDues() == null){
            if (previousPayments.isEmpty()) {
                return flatPaymentRepository.save(flatPayment);
            } else {

                FlatPayment mostRecentPayment = previousPayments.get(previousPayments.size() - 1);
                Date mostRecentPaymentDate = mostRecentPayment.getCreatedAt();

                long timeDifference = todayDate.getTime() - mostRecentPaymentDate.getTime();
                long oneMonthInMillis = 30 * 24 * 60 * 60 * 1000L;

                if (timeDifference >= oneMonthInMillis) {

                    return flatPaymentRepository.save(flatPayment);
                } else {
                    throw new RuntimeException("Payment can only be made once a month.");
                }
            }
        } else {
            if(flatPayment.getDues().equals(0)){
                throw new RuntimeException("Invalid payment Amount");
            }
            else{
                flatDetailsService.updateDues(flatPayment.getFlatDetails());
                flatPaymentRepository.save(flatPayment);
            }
        }
        return flatPayment;
    }
//    public FlatPayment paymentTest(FlatPayment flatPayment) {
//        Date todayDate = new Date();
//        List<FlatPayment> previousPayments = flatPaymentRepository.findByFlatDetails(flatPayment.getFlatDetails());
//
//        if (previousPayments.isEmpty()) {
//            return flatPaymentRepository.save(flatPayment);
//        } else {
//
//            FlatPayment mostRecentPayment = previousPayments.get(previousPayments.size() - 1);
//            Date mostRecentPaymentDate = mostRecentPayment.getCreatedAt();
//
//            long timeDifference = todayDate.getTime() - mostRecentPaymentDate.getTime();
//            long oneMonthInMillis = 30 * 24 * 60 * 60 * 1000L;
//
//            if (timeDifference >= oneMonthInMillis) {
//
//                return flatPaymentRepository.save(flatPayment);
//            } else {
//                throw new RuntimeException("Payment can only be made once a month.");
//            }
//        }
//    }


}
