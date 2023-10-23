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

    private String flatDetails;
    private Integer amount;
    private Integer dueAmount;
}
