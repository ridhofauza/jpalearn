/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatechie.jpa.jpalearn.entity;

import com.javatechie.jpa.jpalearn.dto.OrderResponse;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@SqlResultSetMapping(
    name = "orderMapping",
    classes = {
        @ConstructorResult(
            targetClass = OrderResponse.class,
            columns = {
                @ColumnResult(name = "name"),
                @ColumnResult(name = "product_name"),
                @ColumnResult(name = "price"),
            }
        )
    }
)
@NamedNativeQuery(
        name = "Customer.getAllOrders",
        query = "SELECT c.name, p.product_name, p.price FROM customer c JOIN product p ON c.id=p.cp_fk WHERE p.price > 5000",
        resultSetMapping = "orderMapping",
        resultClass = OrderResponse.class
)   

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String gender;
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
    private List<Product> products;
}
