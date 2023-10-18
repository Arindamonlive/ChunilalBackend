package com.example.Testnew.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flatMonthly")
public class FlatMonthly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flatDetails")
    private String flatDetails;

    @Column(name = "monthlyMaintainance")
    private double monthlyMaintainance;

    // Getters and setters
}
