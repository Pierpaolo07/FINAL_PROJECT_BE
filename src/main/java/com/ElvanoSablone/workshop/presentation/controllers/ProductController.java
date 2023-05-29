package com.ElvanoSablone.workshop.presentation.controllers;

import com.ElvanoSablone.workshop.persistence.entities.Customer;
import com.ElvanoSablone.workshop.persistence.entities.Order;
import com.ElvanoSablone.workshop.persistence.entities.OrderProduct;
import com.ElvanoSablone.workshop.persistence.entities.Product;
import com.ElvanoSablone.workshop.presentation.dto.CustomerDTO;
import com.ElvanoSablone.workshop.presentation.dto.OrderDTO;
import com.ElvanoSablone.workshop.presentation.dto.OrderProductDTO;
import com.ElvanoSablone.workshop.presentation.dto.ProductDTO;
import com.ElvanoSablone.workshop.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable long id) {
        return convertToDTO(productService.getById(id));
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO newProduct) {
        Product product = convertToEntity(newProduct);
        product = productService.create(product);
        return convertToDTO(product);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable long id, @RequestBody ProductDTO updateProduct) {
        Product product = convertToEntity(updateProduct);
        product = productService.update(id, product);
        return convertToDTO(product);
    }

    @DeleteMapping("/{id}")
    public ProductDTO deleteProduct(@PathVariable long id) {
        return convertToDTO(productService.delete(id));
    }


    private ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    private OrderProductDTO convertToOrderProductDTO(OrderProduct orderProduct) {
        return modelMapper.map(orderProduct, OrderProductDTO.class);
    }
}
