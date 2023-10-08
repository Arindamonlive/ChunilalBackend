package com.example.Testnew.Repository;

import com.example.Testnew.Entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepo extends JpaRepository<Complain, Long> {
}
