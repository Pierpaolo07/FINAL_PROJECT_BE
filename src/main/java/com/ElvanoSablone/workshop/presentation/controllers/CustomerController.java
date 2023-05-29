package com.ElvanoSablone.workshop.presentation.controllers;

import com.ElvanoSablone.workshop.persistence.entities.Customer;
import com.ElvanoSablone.workshop.persistence.entities.Order;
import com.ElvanoSablone.workshop.presentation.dto.CustomerDTO;
import com.ElvanoSablone.workshop.presentation.dto.OrderDTO;
import com.ElvanoSablone.workshop.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService.getAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable long id) {
        return convertToDTO(customerService.getById(id));
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO newCustomer) {
        Customer customer = convertToEntity(newCustomer);
        customer = customerService.create(customer);
        return convertToDTO(customer);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable long id, @RequestBody CustomerDTO updateCustomer) {
        Customer customer = convertToEntity(updateCustomer);
        customer = customerService.update(id, customer);
        return convertToDTO(customer);
    }

    @DeleteMapping("/{id}")
    public CustomerDTO deleteCustomer(@PathVariable long id) {
        return convertToDTO(customerService.delete(id));
    }


    private CustomerDTO convertToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private Customer convertToEntity(CustomerDTO dto) {
        return modelMapper.map(dto, Customer.class);
    }

   private OrderDTO convertToOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }
}
