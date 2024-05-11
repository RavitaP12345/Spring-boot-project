package com.example.springsecurityexample.services;

import com.example.springsecurityexample.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    private List<User> store = new ArrayList<>();


    public UserService(){
        store.add(new User("1", "Ravita", "ravita@yopmail.com"));
        store.add(new User("2", "Piush Prajapati", "piush@yopmail.com"));
        store.add(new User("3", "Sandeep Prajapati", "sandeep@yopmail.com"));
    }

    public List<User> getUsers() {
        return store;
    }
}
