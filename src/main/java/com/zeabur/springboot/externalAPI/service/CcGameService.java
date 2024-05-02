package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.GameSearchRequestDto;
import com.zeabur.springboot.ccgames.dto.LoginRequestDto;
import com.zeabur.springboot.ccgames.dto.UserInfoRequestDto;

public interface CcGameService {

    String login(LoginRequestDto loginRequestDto);

    String getUserInfo(UserInfoRequestDto userInfoRequestDto);

    String getGameList(GameListRequestDto gameListRequestDto);

    String searchByGameList(GameSearchRequestDto gameSearchRequestDto);
}
