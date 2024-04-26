package com.zeabur.springboot.externalAPI.service;

import org.springframework.beans.factory.annotation.Value;

public interface CcGameService {

    String getUserInfo(String userId, String authLoginCode);


}
