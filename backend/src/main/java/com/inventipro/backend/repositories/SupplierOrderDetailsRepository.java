package com.inventipro.backend.repositories;

import com.inventipro.backend.entities.SupplierOrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierOrderDetailsRepository extends JpaRepository<SupplierOrderDetailsEntity, Long> {
}
