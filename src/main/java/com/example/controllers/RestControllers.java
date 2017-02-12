package com.example.controllers;
import com.example.dao.CategoryDao;
import com.example.dao.ProductDao;
import com.example.dao.UserDao;
import com.example.entities.Category;
import com.example.entities.Product;
import com.example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 25.01.2017.
 */
@RestController
public class RestControllers {

    @Autowired
    UserDao userDao;

    @Autowired
    CategoryDao catdao;

    @Autowired
    ProductDao productDao;

    @RequestMapping("/t")
    public List<Category> greeting() {
        return catdao.findAll();
    }

    @RequestMapping("/all_prods")
    public List<Product> getProds() {
         return productDao.findAll();
    }

    @RequestMapping("/allCats")
    public List<Category> allcats() {
        List<Category> cats = catdao.findAll();
        /*for (Category c : cats){
            c.setProducts(new ArrayList<Product>());
        }*/
        return cats;
    }
}
