package com.inventipro.backend.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(nullable = false)
    private String customerName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String address;
}
