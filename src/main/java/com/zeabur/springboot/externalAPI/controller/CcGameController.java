package com.zeabur.springboot.externalAPI.controller;

import com.zeabur.springboot.ccgames.dto.LoginRequestDto;
import com.zeabur.springboot.externalAPI.service.CcGameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ccgame")
@CrossOrigin
public class CcGameController {

    @Autowired
    private CcGameService ccGameService;

    @PostMapping(value = "/login", produces = {"application/json"}, consumes = {"application/json"})
    public String login(
            @Valid @RequestBody LoginRequestDto loginRequestDto) {
        return ccGameService.login(loginRequestDto);
    }

    @PostMapping("/getUserInfo")
    public String getUserInfo(String userId, String authLoginCode) {
        return ccGameService.getUserInfo(userId, authLoginCode);
    }

}
