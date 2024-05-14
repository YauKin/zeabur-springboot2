package com.zeabur.springboot.ccgames.service;

import com.zeabur.springboot.ccgames.dto.request.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.request.GameSearchRequestDto;
import com.zeabur.springboot.ccgames.dto.response.GameListResponseDto;

import java.util.List;

public interface GamingService {

    List<GameListResponseDto> getGameList(GameListRequestDto gameListRequestDto);

    List<GameListResponseDto> searchGameByKey(GameSearchRequestDto gameSearchRequestDto);

}
