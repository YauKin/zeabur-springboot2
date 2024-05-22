package com.zeabur.springboot.ccgames.service;

import com.zeabur.springboot.ccgames.dto.request.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.request.GameSearchRequestDto;
import com.zeabur.springboot.constant.ErrorType;
import com.zeabur.springboot.exception.FunctionalException;
import com.zeabur.springboot.externalAPI.dto.response.ApiResponse;
import com.zeabur.springboot.externalAPI.dto.response.GameListResponseDto;
import com.zeabur.springboot.externalAPI.dto.response.GameListRowResponseDto;
import com.zeabur.springboot.externalAPI.service.CcGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<GameListRowResponseDto>> getGameList(GameListRequestDto gameListRequestDto) throws Exception {
        ApiResponse<GameListResponseDto> response = ccGameService.getGameList(gameListRequestDto);
        if (response.getCode() == 200) {
            if (response.getData() != null && response.getData().getRows() != null) {
                return ResponseEntity.ok(response.getData().getRows());
            } else {
                log.error("Game list not found: response data is null or empty");
                throw new FunctionalException(ErrorType.GAME_LIST_NOT_FOUND, "Game list not found: response data is null or empty");
            }
        } else {
            log.error("Failed to get game list from external API, response code: {}", response.getCode());
            throw new FunctionalException(ErrorType.GAME_LIST_NOT_FOUND, "Failed to get game list from external API with response code: " + response.getCode());
        }
    }

    @Override
    public List<GameListResponseDto> searchGameByKey(GameSearchRequestDto gameSearchRequestDto) {
        String jsonString = ccGameService.searchByGameList(gameSearchRequestDto);
        // use Jackson to deserialize the JSON string to List<GameListResponseDto>
        return Collections.emptyList();

    }
}
