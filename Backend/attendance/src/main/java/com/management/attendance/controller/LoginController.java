package com.management.attendance.controller;

import com.management.attendance.dto.AdminUserDTO;
import com.management.attendance.dto.LoginResponse;
import com.management.attendance.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    AdminUserService adminUserService;

    @PostMapping(path ="/login", produces = {"application/json; charset=utf-8"}, consumes = {"application/json; charset=utf-8"})
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid AdminUserDTO user){
       return new ResponseEntity<>(adminUserService.loginAdminUser(user), HttpStatus.OK);
    }
}
