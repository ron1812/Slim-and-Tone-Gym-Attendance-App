package com.openshift.springpoc.demo.service;

import com.openshift.springpoc.demo.entity.User;
import com.openshift.springpoc.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void testRegisterNewUser(){
        User user=new User();
        user.setUsername("Rohan");
        user.setPassword("Password");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User userResponse = userService.registerNewUser(user);
        Assert.assertEquals("Rohan",userResponse.getUsername());
        Assert.assertEquals("Password",userResponse.getPassword());
    }

    @Test
    public void testGetUserList(){
        Mockito.when(userRepository.findAll()).thenReturn(getListOfUsers());
        List<User> userList = userService.getUserList();
        Assert.assertEquals(2,userList.size());
        Assert.assertEquals("Rohan",userList.get(0).getUsername());
        Assert.assertEquals("Pritish",userList.get(1).getUsername());
    }

    public List<User> getListOfUsers(){
        User user1=new User();
        user1.setUsername("Rohan");
        user1.setPassword("Password");
        User user2=new User();
        user2.setUsername("Pritish");
        user2.setPassword("PasswordV2");
        List<User> userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        return userList;
    }
}
