package com.zeabur.springboot.ccgames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfoRequestDto {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("authLoginCode")
    private String authLoginCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthLoginCode() {
        return authLoginCode;
    }

    public void setAuthLoginCode(String authLoginCode) {
        this.authLoginCode = authLoginCode;
    }


}
