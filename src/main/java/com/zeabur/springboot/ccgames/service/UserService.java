package com.zeabur.springboot.ccgames.service;

import com.zeabur.springboot.ccgames.dto.request.LoginRequestDto;

public interface UserService {


    String login(LoginRequestDto loginRequestDto);


}
