package com.example.controllers;

import com.example.configurations.UserDetailsServiceImpl;
import com.example.dao.UserDao;
import com.example.entities.User;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by anton on 24.01.2017.
 */


@Controller
public class MainController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mw = new ModelAndView("index");


        return mw;
    }

    @RequestMapping("/admin")
    public ModelAndView login() {
        ModelAndView mw = new ModelAndView("admin");

        return mw;
    }

    @RequestMapping(value="/new_user" , method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "surname", required = false) String surname,
                                 @RequestParam(value = "phone", required = false) String phone,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password,
                                 HttpServletRequest request) {
        ModelAndView mw = new ModelAndView("login_redirect");
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userDao.saveAndFlush(user);
        mw.addObject("email", email);
        mw.addObject("password", password);
        return mw;
    }
}
