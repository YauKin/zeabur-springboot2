package com.zeabur.springboot.ccgames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zeabur.springboot.constant.GameType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GameSearchRequestDto {
    @NotNull
    @JsonProperty("key")
    private String key;

    @NotNull
    @JsonProperty("page")
    private Integer page;
}
