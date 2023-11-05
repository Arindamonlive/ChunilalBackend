package com.example.Testnew.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;
import java.util.Date;


@Entity
@Table
@Data
public class FlatPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String flatDetails;

    @Column
    private Integer paymentAmount;

    @Column
    private Integer dues;

    @Column
    private String method;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;



    // Getters and setters
}
