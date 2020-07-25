package com.management.attendance.controller;

import com.management.attendance.dto.AdminUserDTO;
import com.management.attendance.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
These apis should be available for only the owners of this application
 */
@RestController
public class UserController {

    @Autowired
    AdminUserService adminUserService;

    @GetMapping("/users")
    public ModelAndView getUsers(){
        List<AdminUserDTO> userLists = adminUserService.getUserList();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("listUsers",userLists);
        modelAndView.setViewName("list-users");
        return modelAndView;
    }

}
