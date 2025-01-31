package com.inventipro.backend.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "SupplierOrderDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierOrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailId;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SupplierOrderEntity order;

    @ManyToOne    @JoinColumn(name = "productId", referencedColumnName = "productId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductEntity product;

    private Integer quantity;

    private Double costPrice;

    private Double totalCost;
}
