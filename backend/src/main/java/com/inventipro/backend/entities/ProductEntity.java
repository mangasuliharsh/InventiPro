package com.inventipro.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "supplierId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private SupplierEntity supplier;

    private Integer quantityInStock;

    @Column(nullable = false)
    private Double price;
}
