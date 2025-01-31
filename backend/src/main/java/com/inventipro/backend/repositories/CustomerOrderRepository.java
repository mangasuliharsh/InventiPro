package com.inventipro.backend.repositories;

import com.inventipro.backend.entities.CustomerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity,Integer> {
}
