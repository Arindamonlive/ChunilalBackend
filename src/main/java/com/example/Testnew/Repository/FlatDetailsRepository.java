package com.example.Testnew.Repository;

import com.example.Testnew.Entity.FlatDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatDetailsRepository extends JpaRepository<FlatDetails, Long> {
    FlatDetails findByFlatDetails(String flatDetails);
}
