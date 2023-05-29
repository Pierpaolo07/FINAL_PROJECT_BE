package com.ElvanoSablone.workshop.persistence.repositories;

import com.ElvanoSablone.workshop.persistence.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
