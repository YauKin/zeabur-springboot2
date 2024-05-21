package com.zeabur.springboot.ccgames.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zeabur.springboot.ccgames.dto.request.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.request.GameSearchRequestDto;
import com.zeabur.springboot.externalAPI.dto.response.ApiResponse;
import com.zeabur.springboot.externalAPI.dto.response.GameListResponseDto;
import com.zeabur.springboot.externalAPI.dto.response.GameListRowResponseDto;
import com.zeabur.springboot.converter.Converter;
import com.zeabur.springboot.externalAPI.service.CcGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<GameListRowResponseDto> getGameList(GameListRequestDto gameListRequestDto) throws Exception {
        String jsonString = ccGameService.getGameList(gameListRequestDto);
        ApiResponse<GameListResponseDto> apiResponse = Converter.jsonToObject(jsonString, new TypeReference<>() {});
        return apiResponse.getData().getRows();
    }

    @Override
    public List<GameListResponseDto> searchGameByKey(GameSearchRequestDto gameSearchRequestDto) {
        String jsonString = ccGameService.searchByGameList(gameSearchRequestDto);
        // use Jackson to deserialize the JSON string to List<GameListResponseDto>
        return Collections.emptyList();

    }
}
