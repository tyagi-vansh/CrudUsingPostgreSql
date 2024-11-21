package com.example.CrudUsingPostgre.controller;

import com.example.CrudUsingPostgre.Entity.User;
import com.example.CrudUsingPostgre.Request.UserRequest;
import com.example.CrudUsingPostgre.Response.ResponseStatus;
import com.example.CrudUsingPostgre.Service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Services services;

    @PostMapping("/add")
    public ResponseStatus addNewUser(@RequestBody UserRequest userRequest){
        return services.addUser(userRequest);
    }

    @GetMapping("/display")
    public List<User> displayUsers(){
        return services.displayUser();
    }

    @PostMapping("/delete/{id}")
    public ResponseStatus deleteUser(@PathVariable int id){
        return services.deleteUser(id);
    }

    @PostMapping("/update/{id}")
    public ResponseStatus updateUser(@PathVariable int id, @RequestBody UserRequest userRequest){
        return services.updateUser(id,userRequest);
    }

}
