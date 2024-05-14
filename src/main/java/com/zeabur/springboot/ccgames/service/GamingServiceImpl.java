package com.zeabur.springboot.ccgames.service;

import com.google.gson.reflect.TypeToken;
import com.zeabur.springboot.ccgames.dto.request.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.request.GameSearchRequestDto;
import com.zeabur.springboot.ccgames.dto.response.GameListResponseDto;
import com.zeabur.springboot.externalAPI.service.CcGameService;
import com.zeabur.springboot.helper.ApiResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GamingServiceImpl implements GamingService {

    private final CcGameService ccGameService;

    @Autowired
    public GamingServiceImpl(CcGameService ccGameService) {
        this.ccGameService = ccGameService;
    }

    @Override
    public List<GameListResponseDto> getGameList(GameListRequestDto gameListRequestDto) {
        String jsonString = ccGameService.getGameList(gameListRequestDto);
        return ApiResponseUtil.deserializeApiResponse(jsonString, new TypeToken<>() {});
    }

    @Override
    public List<GameListResponseDto> searchGameByKey(GameSearchRequestDto gameSearchRequestDto) {
        String jsonString = ccGameService.searchByGameList(gameSearchRequestDto);
        return ApiResponseUtil.deserializeApiResponse(jsonString, new TypeToken<>() {});

    }
}
