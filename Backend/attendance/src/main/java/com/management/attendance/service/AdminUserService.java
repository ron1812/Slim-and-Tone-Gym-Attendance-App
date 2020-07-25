package com.management.attendance.service;

import com.management.attendance.dto.AdminUserDTO;
import com.management.attendance.dto.LoginResponse;
import com.management.attendance.entity.AdminUser;
import com.management.attendance.repository.AdminUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AdminUserService {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Autowired
    ModelMapper modelMapper;

    public AdminUser registerNewUser(AdminUserDTO adminUser){
        AdminUser mappedAdminUser = modelMapper.map(adminUser, AdminUser.class);
        return adminUserRepository.save(mappedAdminUser);
    }

    public List<AdminUserDTO> getUserList()
    {
        List<AdminUser> adminUsers = adminUserRepository.findAll();
        return adminUsers.stream().map(AdminUserDTO::new).collect(Collectors.toList());
    }

    public LoginResponse loginAdminUser(AdminUserDTO adminUser){
        Optional<AdminUser> adminUserResponse = adminUserRepository.findByUsername(adminUser.getUsername());
        if(adminUserResponse.isPresent()){
            AdminUser adminUserEntity = adminUserResponse.get();
            boolean isValidPassword = adminUserEntity.getPassword().equals(adminUser.getPassword());
            return isValidPassword?new LoginResponse("0","Successful Login"):new LoginResponse("401","Incorrect Password");
        }else{
            return new LoginResponse("404","User not found in our database");
        }
    }
}
