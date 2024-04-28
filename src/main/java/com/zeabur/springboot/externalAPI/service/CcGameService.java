package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.LoginRequestDto;

public interface CcGameService {

    String login(LoginRequestDto loginRequestDto);

    String getUserInfo(String userId, String authLoginCode);

}
