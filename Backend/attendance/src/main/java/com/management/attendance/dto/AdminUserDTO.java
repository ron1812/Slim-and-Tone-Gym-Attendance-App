package com.management.attendance.dto;

import com.management.attendance.entity.AdminUser;

import javax.validation.constraints.NotEmpty;

public class AdminUserDTO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public AdminUserDTO(){

    }

    public AdminUserDTO(AdminUser adminUser) {
        this.username = adminUser.getUsername();
        this.password = adminUser.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
