package com.zeabur.springboot.ccgames.controller;

import com.zeabur.springboot.ccgames.dto.request.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.request.GameSearchRequestDto;
import com.zeabur.springboot.externalAPI.dto.response.GameListResponseDto;
import com.zeabur.springboot.externalAPI.dto.response.GameListRowResponseDto;
import com.zeabur.springboot.ccgames.service.GamingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<GameListRowResponseDto>> getGameList(@Valid @RequestBody GameListRequestDto request) throws Exception {
        return gamingService.getGameList(request);
    }

    @PostMapping("/gamelist/search")
    public ResponseEntity<List<GameListRowResponseDto>> searchGameList(@Valid @RequestBody GameSearchRequestDto request) throws Exception {
        return gamingService.searchGameByKey(request);
    }
}
