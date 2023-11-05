package com.example.Testnew.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @UuidGenerator
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String uuId;

    @Column(unique = false,nullable = false)
    private String name;

    @Column(unique = false,nullable = true)
    private String email;

    @Column(unique = true,nullable = false)
    private String phoneNumber;

    @Column(unique = false,nullable = false)
    private String password;
}
