package com.openshift.springpoc.demo.service;

import com.openshift.springpoc.demo.entity.User;
import com.openshift.springpoc.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerNewUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
