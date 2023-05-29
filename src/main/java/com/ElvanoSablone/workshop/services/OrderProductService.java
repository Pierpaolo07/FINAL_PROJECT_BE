package com.ElvanoSablone.workshop.services;

import com.ElvanoSablone.workshop.persistence.entities.Order;
import com.ElvanoSablone.workshop.persistence.entities.OrderProduct;
import com.ElvanoSablone.workshop.persistence.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<OrderProduct> getAll() {
        return orderProductRepository.findAll();
    }

    public OrderProduct getById(long id) {
        Optional<OrderProduct> optionalOrderProduct = orderProductRepository.findById(id);

        if (optionalOrderProduct.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        return optionalOrderProduct.get();
    }

    public OrderProduct create(OrderProduct newOrderProduct) {
        if (newOrderProduct.getOrder() == null || newOrderProduct.getProduct() == null) {
            throw new IllegalStateException("Order and Product must not be null");
        }

        newOrderProduct = orderProductRepository.save(newOrderProduct);

        return newOrderProduct;
    }

    public OrderProduct update(long id, OrderProduct updateOrderProduct) {
        if (updateOrderProduct.getOrder() == null || updateOrderProduct.getProduct() == null) {
            throw new IllegalStateException("Order and Product must not be null");
        }
        Optional<OrderProduct> optionalOrderProduct = orderProductRepository.findById(id);
        if(optionalOrderProduct.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        OrderProduct entityToUpdate = optionalOrderProduct.get();


        entityToUpdate.setOrder(updateOrderProduct.getOrder());
        entityToUpdate.setProduct(updateOrderProduct.getProduct());
        entityToUpdate.setQuantity(updateOrderProduct.getQuantity());

        entityToUpdate = orderProductRepository.save(entityToUpdate);
        updateOrderProduct.setId(entityToUpdate.getId());

        return updateOrderProduct;
    }

    public OrderProduct delete(long id) {
        Optional<OrderProduct> optionalOrderProduct = orderProductRepository.findById(id);

        if (optionalOrderProduct.isEmpty()) {
            throw new IllegalStateException("Entity not found");

        }

        OrderProduct entityToDelete = optionalOrderProduct.get();

        orderProductRepository.delete(entityToDelete);

        return entityToDelete;
    }
}
