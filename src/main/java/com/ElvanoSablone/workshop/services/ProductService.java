package com.ElvanoSablone.workshop.services;


import com.ElvanoSablone.workshop.persistence.entities.Product;
import com.ElvanoSablone.workshop.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {

        return productRepository.findAll();
    }


    public Product getById(long id)  {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Type not found");
        }

        return optionalProduct.get();
    }

    public Product create(Product newProduct) {

        newProduct = productRepository.save(newProduct);
        return newProduct;
    }

    public Product update(long id, Product updateProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        Product entityToUpdate = optionalProduct.get();
        entityToUpdate.setName(updateProduct.getName());
        entityToUpdate.setDescription(updateProduct.getDescription());
        entityToUpdate.setPrice(updateProduct.getPrice());
        entityToUpdate.setCover(updateProduct.getCover());

        entityToUpdate = productRepository.save(entityToUpdate);
        updateProduct.setId(entityToUpdate.getId());
        return updateProduct;
    }

    public Product delete(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }

        Product entityToDelete = optionalProduct.get();

        productRepository.delete(entityToDelete);

        return entityToDelete;
    }
}
