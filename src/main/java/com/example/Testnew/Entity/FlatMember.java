package com.example.Testnew.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table
@Data
public class FlatMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

//    @UuidGenerator
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String fuuId;

    @Column(unique = true,nullable = false)
    private String flatMemberName;

    @Column(unique = true,nullable = false)
    private String flatNumber;

    @Column(unique = true,nullable = false)
    private String blockNumber;


}
