package com.zeabur.springboot.ccgames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zeabur.springboot.constant.GameListType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserGameListRequestDto {

    @NotNull
    @JsonProperty("userId")
    private String userId;

    @NotNull
    @JsonProperty("gameListType")
    private GameListType gameListType;

    @NotNull
    @JsonProperty("authLoginCode")
    private String authLoginCode;

}
