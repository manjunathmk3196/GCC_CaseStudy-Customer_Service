package com.example.customer.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document
@Getter @Setter
public class Customer {
    @Id
    private String id;

    private String email;
    private String first_name;
    private String last_name;
}