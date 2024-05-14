package com.zeabur.springboot.ccgames.controller;

import com.zeabur.springboot.ccgames.dto.request.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.request.GameSearchRequestDto;
import com.zeabur.springboot.ccgames.dto.response.GameListResponseDto;
import com.zeabur.springboot.ccgames.service.GamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GamingController {

    private final GamingService gamingService;
    @Autowired
    public GamingController(GamingService gamingService) {
        this.gamingService = gamingService;
    }

    @PostMapping("/gamelist")
    public List<GameListResponseDto> getGameList(GameListRequestDto request){
        return gamingService.getGameList(request);
    }

    @PostMapping("/gamelist/search")
    public List<GameListResponseDto> searchGameList(GameSearchRequestDto request){
        return gamingService.searchGameByKey(request);
    }
}
