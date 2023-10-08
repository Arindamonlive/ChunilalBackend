package com.example.Testnew.Repository;

import com.example.Testnew.Entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {
}
