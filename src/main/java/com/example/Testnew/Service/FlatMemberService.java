package com.example.Testnew.Service;


import com.example.Testnew.Entity.FlatMember;
import com.example.Testnew.Repository.FlatMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlatMemberService {

    @Autowired
    private FlatMemberRepo flatMemberRepo;

    public Optional<FlatMember> getOneFlatmember(Long Id){
        return flatMemberRepo.findById(Id);
    }

    public Optional<FlatMember> getFlatMemberName(Long Id){
        return flatMemberRepo.findById(Id);
    }

    public Optional<FlatMember> getFlatNumber(Long Id){
        return flatMemberRepo.findById(Id);
    }
    public Optional<FlatMember> getFlatBlock(Long Id){
        return  flatMemberRepo.findById(Id);
    }
    public FlatMember addMember(FlatMember flatMember){
        return flatMemberRepo.save(flatMember);
    }

    public FlatMember updateMember(FlatMember flatMember){
        return flatMemberRepo.save(flatMember);
    }



}
