package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.LoginRequestDto;
import com.zeabur.springboot.ccgames.dto.UserInfoRequestDto;
import com.zeabur.springboot.helper.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CcGameServiceImpl implements CcGameService {

    @Autowired
    private RestHelper restHelper;

    @Value("${ccgame.api.url}")
    private String ccGameUrl;

    private final Map<String, String> headers;
    public CcGameServiceImpl() {
        headers = new HashMap<>();
        headers.put("Site-Source", "http://tw.frxgame.com");
    }

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        String apiUrl = ccGameUrl + "user/login/?phone=" + loginRequestDto.getUsername() + "&pwd=" + loginRequestDto.getPassword();
        return restHelper.doGet(apiUrl, String.class, headers, true);
    }

    @Override
    public String getUserInfo(UserInfoRequestDto userInfoRequestDto) {
        String apiUrl = ccGameUrl + "user/getUserInfo/?userId=" + userInfoRequestDto.getUserId() + "&authLoginCode=" + userInfoRequestDto.getAuthLoginCode();
        return restHelper.doGet(apiUrl, String.class, headers, true);
    }

}
