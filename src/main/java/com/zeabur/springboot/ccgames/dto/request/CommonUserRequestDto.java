package com.zeabur.springboot.ccgames.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommonUserRequestDto {
    @NotNull
    @JsonProperty("userId")
    private String userId;

    @NotNull
    @JsonProperty("authLoginCode")
    private String authLoginCode;
}
