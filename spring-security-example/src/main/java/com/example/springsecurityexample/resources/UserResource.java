package com.example.springsecurityexample.resources;

import com.example.springsecurityexample.models.User;
import com.example.springsecurityexample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUser(){
        System.out.println("getting users");
        return userService.getUsers();
    }

}
