/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatechie.jpa.jpalearn.controller;

import com.javatechie.jpa.jpalearn.dto.OrderRequest;
import com.javatechie.jpa.jpalearn.dto.OrderResponse;
import com.javatechie.jpa.jpalearn.entity.Customer;
import com.javatechie.jpa.jpalearn.repository.CustomerRepository;
import com.javatechie.jpa.jpalearn.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    
    @PostMapping("/placeOrder")
    private Customer placeOrder(@RequestBody OrderRequest request) {
        return customerRepository.save(request.getCustomer());
    }
    
    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders() {
        return customerRepository.findAll();
    }
    
    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation() {        
        // JPQL
        return customerRepository.getJoinInformation();
    }
    
    @GetMapping("/getInfoObj")
    public List<OrderResponse> getJoinInformationNative() {
        // Native Query
        return customerRepository.getAllOrders();
    }
}
