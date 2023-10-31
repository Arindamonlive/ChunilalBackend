package com.example.Testnew.Repository;

import com.example.Testnew.Entity.Committee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommitteeRepo extends JpaRepository<Committee, Long> {
    Optional<Committee> findByUserName(String userName);
}
