package com.inventipro.backend.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "SupplierOrders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "supplierId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SupplierEntity supplier;

    private LocalDateTime orderDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;
}
