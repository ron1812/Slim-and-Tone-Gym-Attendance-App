package com.openshift.springpoc.demo.controller;

import com.openshift.springpoc.demo.entity.User;
import com.openshift.springpoc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ModelAndView getUsers(){
        List<User> userLists = userService.getUserList();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("listUsers",userLists);
        modelAndView.setViewName("list-users");
        return modelAndView;
    }

}
