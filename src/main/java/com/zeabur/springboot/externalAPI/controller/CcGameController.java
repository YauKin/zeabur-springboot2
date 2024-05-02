package com.zeabur.springboot.externalAPI.controller;

import com.zeabur.springboot.ccgames.dto.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.GameSearchRequestDto;
import com.zeabur.springboot.ccgames.dto.LoginRequestDto;
import com.zeabur.springboot.ccgames.dto.UserInfoRequestDto;
import com.zeabur.springboot.externalAPI.service.CcGameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ccgame")
@CrossOrigin
public class CcGameController {

    private final CcGameService ccGameService;

    @Autowired
    public CcGameController(CcGameService ccGameService) {
        this.ccGameService = ccGameService;
    }

    @PostMapping(value = "/login", produces = {"application/json"}, consumes = {"application/json"})
    public String login(
            @Valid @RequestBody LoginRequestDto loginRequestDto) {
        return ccGameService.login(loginRequestDto);
    }

    @PostMapping("/getUserInfo")
    public String getUserInfo(
            @Valid @RequestBody UserInfoRequestDto userInfoRequestDto
    ) {
        return ccGameService.getUserInfo(userInfoRequestDto);
    }

    @PostMapping("/getGameList")
    public String getGameList(
            @Valid @RequestBody GameListRequestDto gameListRequestDto
    ){
        return ccGameService.getGameList(gameListRequestDto);
    }

    @PostMapping("/searchGame")
    public String searchGame(
            @Valid @RequestBody GameSearchRequestDto gameSearchRequestDto
    ){
        return ccGameService.searchByGameList(gameSearchRequestDto);
    }

}
