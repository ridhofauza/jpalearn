/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatechie.jpa.jpalearn.repository;

import com.javatechie.jpa.jpalearn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
