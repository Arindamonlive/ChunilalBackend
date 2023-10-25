package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatDetails;
import com.example.Testnew.Repository.FlatDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlatDetailsService {

    @Autowired
    private FlatDetailsRepository flatDetailsRepository;

//    public FlatDetails payMonthlyAmount(String flatDetails, Integer payment) {
//        FlatDetails flat = flatDetailsRepository.findByFlatDetails(flatDetails); // Change method name
//
//        if (flat != null) {
//            Integer currentAmount = flat.getAmount();
//            Integer currentDueAmount = flat.getDueAmount();
//
//            if (payment >= currentAmount) {
//                // Flat owner paid the full amount, reset due amount
//                flat.setAmount(0);
//                flat.setDueAmount(0);
//            } else {
//                // Partial payment, update due amount
//                flat.setAmount((currentAmount - payment));
//                flat.setDueAmount((currentDueAmount + (currentAmount - payment)));
//            }
//
//            return flatDetailsRepository.save(flat);
//        }
//
//        return null;
//    }
    public FlatDetails addAmount(FlatDetails flatDetails){
        return flatDetailsRepository.save(flatDetails);
    }

    public FlatDetails getAmount(String flatDetails){
        return flatDetailsRepository.findByflatDetails(flatDetails);
    }
//    public FlatDetails payMonthlyAmount(String flatDetails, double payment) {
//        FlatDetails flat = flatDetailsRepository.findByFlatDetails(flatDetails);
//
//        if (flat != null) {
//            double currentAmount = flat.getAmount();
//            double currentDueAmount = flat.getDueAmount();
//
//            if (payment >= currentAmount) {
//                // Flat owner paid the full amount, reset due amount
//                flat.setAmount(0);
//                flat.setDueAmount(0);
//            } else {
//                // Partial payment, update due amount
//                flat.setAmount((int) (currentAmount - payment));
//                flat.setDueAmount((int) (currentDueAmount + (currentAmount - payment)));
//            }
//
//            return flatDetailsRepository.save(flat);
//        }
//
//        return null;
//    }


//        @Scheduled(cron = "*/30 * * * * *") //  Run at every 30s
    @Scheduled(cron = "0 0 0 */30 * *")
    public void updateMonthlyPayments() {
        List<FlatDetails> flatDetailsList = flatDetailsRepository.findAll();

        for (FlatDetails flat : flatDetailsList) {
            Integer currentAmount = flat.getAmount();
            Integer currentDueAmount = flat.getDueAmount();


            flat.setDueAmount(currentDueAmount + currentAmount);
            flat.setAmount(currentAmount);

            flatDetailsRepository.save(flat);
        }
            System.out.println("Scheduled task completed at " + new Date());
    }
}

