package com.example.dao;

import com.example.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by anton on 04.02.2017.
 */
@Repository
public interface ProductDao extends JpaRepository<Product,Long> {
}