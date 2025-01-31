package com.inventipro.backend.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    @Column(nullable = false)
    private String supplierName;

    private String contactName;

    private String phone;

    @Column(unique = true)
    private String email;

    private String address;
}
