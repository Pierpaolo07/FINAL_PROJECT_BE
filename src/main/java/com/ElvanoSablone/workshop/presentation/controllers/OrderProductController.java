package com.ElvanoSablone.workshop.presentation.controllers;

import com.ElvanoSablone.workshop.persistence.entities.Customer;
import com.ElvanoSablone.workshop.persistence.entities.Order;
import com.ElvanoSablone.workshop.persistence.entities.OrderProduct;
import com.ElvanoSablone.workshop.persistence.entities.Product;
import com.ElvanoSablone.workshop.presentation.dto.CustomerDTO;
import com.ElvanoSablone.workshop.presentation.dto.OrderDTO;
import com.ElvanoSablone.workshop.presentation.dto.OrderProductDTO;
import com.ElvanoSablone.workshop.presentation.dto.ProductDTO;
import com.ElvanoSablone.workshop.services.CustomerService;
import com.ElvanoSablone.workshop.services.OrderProductService;
import com.ElvanoSablone.workshop.services.OrderService;
import com.ElvanoSablone.workshop.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_products")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<OrderProductDTO> getOrderProduct() {
        return orderProductService.getAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }


   /* @GetMapping("/{id}")
    public OrderProductDTO getOrderProductById(@PathVariable long id) {
        return convertToDTO(orderProductService.getById(id));
    }

    /*@GetMapping("/{idOrder}/products")
    public List<ProductDTO> getProductsByIdOrder(@PathVariable long idOrder) {
        return convertToDTO(orderProductService.getById(id)); //getProductsByIdOrder(idOrder)
    } */
    @PostMapping
    public OrderProductDTO createOrderProduct(@RequestBody OrderProductDTO newOrderProduct) {
        OrderProduct orderProduct = convertToEntity(newOrderProduct);

        orderProduct = orderProductService.create(orderProduct);

        return convertToDTO(orderProduct);
    }

    @PutMapping("/{id}")
    public OrderProductDTO updateOrderProduct(@PathVariable long id, @RequestBody OrderProductDTO updateOrderProduct) {
        OrderProduct orderProduct = convertToEntity(updateOrderProduct);

        orderProduct = orderProductService.update(id, orderProduct);

        return convertToDTO(orderProduct);
    }

    @DeleteMapping ("/{id}")
    public OrderProductDTO deleteOrderProduct(@PathVariable long id){
        return convertToDTO(orderProductService.delete(id));
    }
    private OrderProductDTO convertToDTO(OrderProduct orderProduct) {
        return modelMapper.map(orderProduct, OrderProductDTO.class);
    }

    private OrderProduct convertToEntity(OrderProductDTO dto) {
        return modelMapper.map(dto, OrderProduct.class);
    }

    private OrderDTO convertToOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    private ProductDTO convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }



}
