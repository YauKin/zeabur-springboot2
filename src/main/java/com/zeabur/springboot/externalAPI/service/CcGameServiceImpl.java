package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.helper.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CcGameServiceImpl implements CcGameService {

    @Autowired
    private RestHelper restHelper;

    @Value("${cc.game.url}")
    private String getGameUrl;

    @Override
    public String getUserInfo(String userId, String authLoginCode) {
        return restHelper.doGet(getGameUrl + "/getUserInfo/?userId=" + userId + "&authLoginCode=" + authLoginCode, String.class);
    }

}
