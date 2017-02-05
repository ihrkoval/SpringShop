package com.example.dao;

import com.example.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by anton on 04.02.2017.
 */
@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {
}
