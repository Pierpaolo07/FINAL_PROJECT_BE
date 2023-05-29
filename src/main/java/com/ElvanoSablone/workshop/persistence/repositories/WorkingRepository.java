package com.ElvanoSablone.workshop.persistence.repositories;

import com.ElvanoSablone.workshop.persistence.entities.Working;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingRepository extends JpaRepository<Working, Long> {
}
