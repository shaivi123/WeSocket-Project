package com.springrest.webSocket.controller;

import com.springrest.webSocket.dto.UserRequest;
import com.springrest.webSocket.model.User;
import com.springrest.webSocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User createUser(@RequestBody UserRequest dto){
        return userService.createUser(dto.getUserName(),dto.getPassword());
    }
}
