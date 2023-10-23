package com.example.Testnew.Repository;

import com.example.Testnew.Entity.FlatPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlatPaymentRepository extends JpaRepository<FlatPayment, Long> {


    List<FlatPayment> findByFlatDetails(String flatDetails);



}
