package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.LoginRequestDto;
import com.zeabur.springboot.helper.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CcGameServiceImpl implements CcGameService {

    @Autowired
    private RestHelper restHelper;

    @Value("${ccgame.api.url}")
    private String ccGameUrl;

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        return restHelper.doGet(ccGameUrl + "user/login/?phone=" + loginRequestDto.getUsername() + "&pwd=" + loginRequestDto.getPassword(), String.class, true);
    }

    @Override
    public String getUserInfo(String userId, String authLoginCode) {
        return restHelper.doGet(ccGameUrl + "getUserInfo/?userId=" + userId + "&authLoginCode=" + authLoginCode, String.class, true);
    }

}
