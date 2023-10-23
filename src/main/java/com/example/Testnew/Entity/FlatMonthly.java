package com.example.Testnew.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class FlatMonthly {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String flatDetails;

    @Column(nullable = false)
    private Integer monthlyMaintenance;

    // Getters and setters
}
