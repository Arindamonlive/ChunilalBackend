package com.example.Testnew.Repository;

import com.example.Testnew.Entity.FlatPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatPaymentRepository extends JpaRepository<FlatPayment, Long> {
}
