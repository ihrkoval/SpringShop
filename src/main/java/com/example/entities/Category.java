package com.example.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 04.02.2017.
 */

@Entity
@Table(name = "Categories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy= "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> product;

    public Category(String name) { //, List<Product> products
        this.name = name;
        //this.product = products;
    }

    public Category(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /*@JsonIgnore
    public List<Product> getProducts() {
        return null;
    }*/

    /*public void setProducts(List<Product> products) {
        this.product = products;
    }*/
}
