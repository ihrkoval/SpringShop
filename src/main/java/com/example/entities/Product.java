package com.example.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

/**
 * Created by anton on 24.01.2017.
 */
@Entity
@Table(name = "Products")
//@JsonAutoDetect
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category")
    private Category category;

    private double price;
    private String photo;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="product")
    private Order orders;


    public Product(){}

    public Product(String name, Category category, double price, String photo, String description) {

        this.name = name;
        this.category = category;
        this.price = price;
        this.photo = photo;
        this.description = description;
    }



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

    public Category getCat() {
        return category;
    }

    public void setCat(String cat_id) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }
}