package com.inventipro.backend.repositories;

import com.inventipro.backend.entities.CustomerOrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderDetailsRepository extends JpaRepository<CustomerOrderDetailsEntity,Integer> {
}
