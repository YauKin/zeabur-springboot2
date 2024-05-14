package com.zeabur.springboot.ccgames.dto.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    String msg;
    int code;
    DataWrapper<T> data;

}
