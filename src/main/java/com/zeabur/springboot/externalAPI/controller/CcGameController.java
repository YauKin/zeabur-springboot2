package com.zeabur.springboot.externalAPI.controller;

import com.zeabur.springboot.externalAPI.service.CcGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ccgame")
public class CcGameController {

    @Autowired
    private CcGameService ccGameService;

    @PostMapping("/getUserInfo")
    public String getUserInfo(String userId, String authLoginCode){
        return ccGameService.getUserInfo(userId, authLoginCode);
    }

}
