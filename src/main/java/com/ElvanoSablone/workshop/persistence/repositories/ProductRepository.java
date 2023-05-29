package com.ElvanoSablone.workshop.persistence.repositories;

import com.ElvanoSablone.workshop.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
