package com.ElvanoSablone.workshop.presentation.controllers;

import com.ElvanoSablone.workshop.persistence.entities.Customer;
import com.ElvanoSablone.workshop.persistence.entities.Order;
import com.ElvanoSablone.workshop.presentation.dto.CustomerDTO;
import com.ElvanoSablone.workshop.presentation.dto.OrderDTO;
import com.ElvanoSablone.workshop.services.CustomerService;
import com.ElvanoSablone.workshop.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.getAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable long id) {
        return convertToDTO(orderService.getById(id));
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO newOrder) {
        Order order = convertToEntity(newOrder);

        order = orderService.create(order);

        return convertToDTO(order);
    }

    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable long id, @RequestBody OrderDTO updateOrder) {
        Order order = convertToEntity(updateOrder);

        order = orderService.update(id, order);

        return convertToDTO(order);
    }
    @DeleteMapping ("/{id}")
    public OrderDTO deleteOrder(@PathVariable long id){
        return convertToDTO(orderService.delete(id));
    }






    private OrderDTO convertToDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    private Order convertToEntity(OrderDTO dto) {
        return modelMapper.map(dto, Order.class);
    }

    private CustomerDTO convertToCustomerDTO(Customer song) {
        return modelMapper.map(song, CustomerDTO.class);
    }
}
