package com.zeabur.springboot.ccgames.service;

import com.zeabur.springboot.ccgames.dto.request.LoginRequestDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        return "Hello, Login Testing";
    }

}
