package com.zeabur.springboot.ccgames.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zeabur.springboot.ccgames.dto.request.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.response.ApiResponse;
import com.zeabur.springboot.ccgames.dto.response.GameListResponseDto;
import com.zeabur.springboot.externalAPI.service.CcGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Collections;
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
        Gson gson = new Gson();
        String jsonString = ccGameService.getGameList(gameListRequestDto);
        Type responseType = new TypeToken<ApiResponse<GameListResponseDto>>(){}.getType();

        ApiResponse<GameListResponseDto> apiResponse = gson.fromJson(jsonString, responseType);
        List<GameListResponseDto> gameListResponseDtoList;

        if(apiResponse.getCode() == 200){
            gameListResponseDtoList = apiResponse.getData().getRows();
        }else {
            gameListResponseDtoList = Collections.emptyList();
        }
        return gameListResponseDtoList;
    }
}
