package com.ElvanoSablone.workshop.services;

import com.ElvanoSablone.workshop.persistence.entities.Order;
import com.ElvanoSablone.workshop.persistence.entities.Working;
import com.ElvanoSablone.workshop.persistence.repositories.WorkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingService {

    @Autowired
    private WorkingRepository workingRepository;

    public List<Working> getAll() {
        return workingRepository.findAll();
    }

    public Working getById(long id) {
        Optional<Working> optionalWorking = workingRepository.findById(id);

        if (optionalWorking.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        return optionalWorking.get();
    }

    public Working create(Working newWorking) {
        if (newWorking.getOrderProduct() == null) {
            throw new IllegalStateException("OrderProduct must not be null");
        }

        newWorking = workingRepository.save(newWorking);

        return newWorking;
    }

    public Working update(long id, Working updateWorking) {
        if (updateWorking.getOrderProduct() == null) {
            throw new IllegalStateException("OrderProducts must not be null");
        }
        Optional<Working> optionalWorking = workingRepository.findById(id);
        if(optionalWorking.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        Working entityToUpdate = optionalWorking.get();

        updateWorking.setId(entityToUpdate.getId());

        updateWorking = workingRepository.save(updateWorking);

        return updateWorking;
    }

    public Working delete(long id) {
        Optional<Working> optionalWorking = workingRepository.findById(id);

        if (optionalWorking.isEmpty()) {
            throw new IllegalStateException("Entity not found");

        }

        Working entityToDelete = optionalWorking.get();

        workingRepository.delete(entityToDelete);

        return entityToDelete;
    }
}
