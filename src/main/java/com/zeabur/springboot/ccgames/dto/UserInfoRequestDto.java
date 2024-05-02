package com.zeabur.springboot.ccgames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfoRequestDto {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("authLoginCode")
    private String authLoginCode;

}
