package com.zeabur.springboot.ccgames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserInfoRequestDto {

    @NotNull
    @JsonProperty("userId")
    private String userId;

    @NotNull
    @JsonProperty("authLoginCode")
    private String authLoginCode;

}
