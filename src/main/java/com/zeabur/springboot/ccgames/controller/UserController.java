package com.zeabur.springboot.ccgames.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
@CrossOrigin
public class UserController {

    @PostMapping("getUserInfo")
    public String getUserInfo() {
        return "User Info";
    }

}

