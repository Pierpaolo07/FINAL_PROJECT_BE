package com.ElvanoSablone.workshop.persistence.repositories;

import com.ElvanoSablone.workshop.persistence.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
