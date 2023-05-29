package com.ElvanoSablone.workshop.services;

import com.ElvanoSablone.workshop.persistence.entities.Customer;
import com.ElvanoSablone.workshop.persistence.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {

        return customerRepository.findAll();
    }


    public Customer getById(long id)  {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new IllegalStateException("Type not found");
        }

        return optionalCustomer.get();
    }

    public Customer create(Customer newCustomer) {

        newCustomer = customerRepository.save(newCustomer);
        return newCustomer;
    }

    public Customer update(long id, Customer updateCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        Customer entityToUpdate = optionalCustomer.get();
        entityToUpdate.setName(updateCustomer.getName());
        entityToUpdate.setSurname(updateCustomer.getSurname());
        entityToUpdate.setPhone(updateCustomer.getPhone());
        entityToUpdate.setEmail(updateCustomer.getEmail());

        entityToUpdate = customerRepository.save(entityToUpdate);
        updateCustomer.setId(entityToUpdate.getId());
        return updateCustomer;
    }

    public Customer delete(long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        Customer entityToDelete = optionalCustomer.get();

        customerRepository.delete(entityToDelete);

        return entityToDelete;
    }

}