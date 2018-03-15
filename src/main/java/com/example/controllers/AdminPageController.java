package com.example.controllers;

import com.example.dao.CategoryDao;
import com.example.dao.ProductDao;
import com.example.dao.UserDao;
import com.example.entities.Category;
import com.example.entities.Product;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

/**
 * Created by anton on 04.02.2017.
 */

@Controller
public class AdminPageController implements ServletContextAware {

    @Autowired
    private CategoryDao catDao;

    @Autowired
    private ProductDao productDao;

    ServletContext servletContext;

    @RequestMapping(value="/addcat" , method = RequestMethod.POST)
    public ModelAndView index(@RequestParam(value = "name") String name) {
        Category cat = new Category();
        cat.setName(name);
        catDao.saveAndFlush(cat);
        ModelAndView mw = new ModelAndView("admin");
        return mw;
    }

    @RequestMapping(value="/addgoods" , method = RequestMethod.POST)
    public ModelAndView addGoods(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "cat") long cat,
                                 @RequestParam(value = "price") double price,
                                 @RequestParam(value = "comment") String desc,
                                 @RequestParam(value = "photo") MultipartFile photo) {

        ModelAndView mw = new ModelAndView("admin");
        System.out.println(name);
        try {
            File file = new File(servletContext.getRealPath("/")+"WEB-INF/classes/public/img/goods/"+ System.currentTimeMillis()+photo.getOriginalFilename());
            FileUtils.writeByteArrayToFile(file, photo.getBytes());
            String path = file.getAbsolutePath();
            Category category = catDao.getOne(cat);
            Product p = new Product(name, category, price, path, desc);
            productDao.saveAndFlush(p);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return mw;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}


     /*   try {
            File file = new File("static/img/goods/"+ System.currentTimeMillis()+photo.getOriginalFilename());
            FileUtils.writeByteArrayToFile(file, photo.getBytes());
            String path = file.getAbsolutePath();
            System.out.println(name+ " CATEGORY");
            Category category = catDao.getOne(cat);
            Product p = new Product(name, category, price, path, desc);
            productDao.saveAndFlush(p);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
