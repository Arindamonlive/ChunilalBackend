package com.example.Testnew.Repository;

import com.example.Testnew.Entity.FlatMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlatMemberRepo extends JpaRepository<FlatMember,Long> {

    Optional<FlatMember> findByFlatMemberName(String flatMemberName);
}
