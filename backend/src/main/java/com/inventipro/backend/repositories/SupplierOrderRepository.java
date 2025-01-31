package com.inventipro.backend.repositories;

import com.inventipro.backend.entities.SupplierOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierOrderRepository extends JpaRepository<SupplierOrderEntity,Integer> {
}
