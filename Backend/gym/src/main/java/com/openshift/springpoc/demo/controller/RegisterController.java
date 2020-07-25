package com.openshift.springpoc.demo.controller;

import com.openshift.springpoc.demo.entity.User;
import com.openshift.springpoc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView registrationPage(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("isClient",true);
        mav.addObject("expiration_date_time",null);
        mav.setViewName("register");
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView registration(@Valid @ModelAttribute User user){
        try{
            userService.registerNewUser(user);
            return new ModelAndView("success");
        }catch(Exception e){
            ModelAndView mav = new ModelAndView();
            mav.addObject("errorMsg", "Username already exists");
            mav.setViewName("error");
            return mav;
        }
    }
}
