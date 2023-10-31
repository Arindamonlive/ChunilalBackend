package com.example.Testnew.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String userName;

    String password;
}
