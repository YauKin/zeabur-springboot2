package com.zeabur.springboot.externalAPI.dto.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    String msg;
    int code;
    T data;
}
