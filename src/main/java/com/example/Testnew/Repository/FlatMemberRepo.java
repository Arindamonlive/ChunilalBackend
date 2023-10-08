package com.example.Testnew.Repository;

import com.example.Testnew.Entity.FlatMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatMemberRepo extends JpaRepository<FlatMember,Long> {
}
