package com.zeabur.springboot.ccgames.service;

import com.zeabur.springboot.ccgames.dto.request.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.request.GameSearchRequestDto;
import com.zeabur.springboot.externalAPI.dto.response.GameListResponseDto;
import com.zeabur.springboot.externalAPI.dto.response.GameListRowResponseDto;

import java.util.List;

public interface GamingService {

    List<GameListRowResponseDto> getGameList(GameListRequestDto gameListRequestDto) throws Exception;

    List<GameListResponseDto> searchGameByKey(GameSearchRequestDto gameSearchRequestDto);

}
