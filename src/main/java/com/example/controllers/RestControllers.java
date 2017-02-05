package com.example.controllers;
import com.example.dao.CategoryDao;
import com.example.dao.UserDao;
import com.example.entities.Category;
import com.example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/t")
    public List<User> greeting() {
        return userDao.findAll();
    }

    @RequestMapping("/allCats")
    public List<Category> allcats() {
        return catdao.findAll();
    }
}
