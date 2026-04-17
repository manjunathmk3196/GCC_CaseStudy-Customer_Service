package com.example.customer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String name;
    private String address;
}