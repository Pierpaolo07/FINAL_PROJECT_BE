package com.ElvanoSablone.workshop.persistence.repositories;

import com.ElvanoSablone.workshop.persistence.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
