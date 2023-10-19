package com.example.Testnew.Entity;

import jakarta.persistence.*;

import java.security.Timestamp;


@Entity
@Table(name = "flatPayment")
public class FlatPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flatDetails")
    private FlatMonthly flatDetails;

    @Column(name = "paymentAmount")
    private double paymentAmount;

    @Column(name = "dues")
    private double dues;

    @Column(name = "timestamp")
    private Timestamp timestamp;


    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getInvoiceNumber() {
        return getInvoiceNumber();
    }

    // Getters and setters
}
