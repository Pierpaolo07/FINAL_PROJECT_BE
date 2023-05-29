package com.ElvanoSablone.workshop.services;

import com.ElvanoSablone.workshop.persistence.entities.Order;
import com.ElvanoSablone.workshop.persistence.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAll() {
        return orderRepository.findAll();
    }


    public Order getById(long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        return optionalOrder.get();
    }


    public Order create(Order newOrder) {
        if (newOrder.getCustomer() == null) {
            throw new IllegalStateException("Customer must not be null");
        }



        newOrder = orderRepository.save(newOrder);

        return newOrder;
    }

    public Order update(long id, Order updateOrder) {
        if (updateOrder.getCustomer() == null) {
            throw new IllegalStateException("Order must not be null");
        }
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        Order entityToUpdate = optionalOrder.get();


        entityToUpdate.setDateOrder(updateOrder.getDateOrder());
        entityToUpdate.setDateDelivery(updateOrder.getDateDelivery());
        entityToUpdate.setInvoice(updateOrder.getInvoice());
        entityToUpdate.setCustomer(updateOrder.getCustomer());

        entityToUpdate = orderRepository.save(entityToUpdate);
        updateOrder.setId(entityToUpdate.getId());

        return updateOrder;
    }

    public Order delete(long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isEmpty()) {
            throw new IllegalStateException("Entity not found");

        }

        Order entityToDelete = optionalOrder.get();

        orderRepository.delete(entityToDelete);

        return entityToDelete;
    }


}

