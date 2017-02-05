package com.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 04.02.2017.
 */

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy= "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> product = new ArrayList<Product>();

    public Category(String name, List<Product> products) {
        this.name = name;
        this.product = products;
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

    public List<Product> getProducts() {
        return product;
    }

    public void setProducts(List<Product> products) {
        this.product = products;
    }
}
