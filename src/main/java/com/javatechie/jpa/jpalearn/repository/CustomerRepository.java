/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatechie.jpa.jpalearn.repository;

import com.javatechie.jpa.jpalearn.dto.OrderResponse;
import com.javatechie.jpa.jpalearn.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
    @Query("SELECT new com.javatechie.jpa.jpalearn.dto.OrderResponse(c.name, p.productName, p.price) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
    
    @Query(nativeQuery = true)
    public List<OrderResponse> getAllOrders();
}
