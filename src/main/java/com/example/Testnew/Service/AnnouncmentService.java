package com.example.Testnew.Service;


import com.example.Testnew.Entity.Announcement;
import com.example.Testnew.Entity.Complain;
import com.example.Testnew.Repository.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncmentService {
    @Autowired
    private AnnouncementRepo announcementRepo;

    public Announcement addAnn(Announcement announcement){ return announcementRepo.save(announcement);}

    public List<Announcement> getAnn(){return announcementRepo.findAll();}

}
