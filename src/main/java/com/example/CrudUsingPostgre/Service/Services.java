package com.example.CrudUsingPostgre.Service;

import com.example.CrudUsingPostgre.Entity.User;
import com.example.CrudUsingPostgre.Repository.UserRepository;
import com.example.CrudUsingPostgre.Request.UserRequest;
import com.example.CrudUsingPostgre.Response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Services {

    @Autowired
    private UserRepository userRepository;

    public ResponseStatus addUser(UserRequest userRequest){
        ResponseStatus message = new ResponseStatus();
        User adduser = new User();

        adduser.setName(userRequest.getName());
        adduser.setMobile(userRequest.getMobile());
        userRepository.save(adduser);
        message.setMessage("user successfully added");
        return message;
    }
    public List<User> displayUser(){
        List<User> users=userRepository.findAll();

        return users;
    }

    public ResponseStatus deleteUser(int id){
        User delUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
        ResponseStatus message = new ResponseStatus();
        if(delUser!= null){
            userRepository.delete(delUser);
            message.setMessage("user successfully deleted");
            return message;
        }
        message.setMessage("User not found");
        return message;
    }
    public ResponseStatus updateUser(int id,UserRequest userRequest){
        User updateUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
        ResponseStatus message = new ResponseStatus();
        if(updateUser!=null){
            updateUser.setName(userRequest.getName());
            updateUser.setMobile(userRequest.getMobile());
            userRepository.save(updateUser);
            message.setMessage("User updated Successfully");
            return message;
        }
        message.setMessage("user not found");
        return message;
    }
}
