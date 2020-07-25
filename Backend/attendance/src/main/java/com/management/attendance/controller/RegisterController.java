package com.management.attendance.controller;

import com.management.attendance.dto.AdminUserDTO;
import com.management.attendance.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/*
These apis should be available for only the owners of this application
 */
@Controller
public class RegisterController {

    @Autowired
    AdminUserService adminUserService;

    @GetMapping("/")
    public ModelAndView registrationPage(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("register");
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView registration(@ModelAttribute AdminUserDTO user){
        try{
            adminUserService.registerNewUser(user);
            return new ModelAndView("success");
        }catch(Exception e){
            ModelAndView mav = new ModelAndView();
            mav.addObject("errorMsg", "Username already exists");
            mav.setViewName("error");
            return mav;
        }
    }
}
