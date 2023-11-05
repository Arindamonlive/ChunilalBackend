package com.example.Testnew.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class FlatDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String flatDetails;
    @Column(unique = false,nullable = false)
    private Integer amount;
    @Column(unique = false,nullable = false)
    private Integer dueAmount;
}
