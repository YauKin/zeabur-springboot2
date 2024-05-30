package com.zeabur.springboot.ccgames.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GameSearchRequestDto {
    @NotNull
    @JsonProperty("searchText")
    private String searchText;

    @NotNull
    @JsonProperty("page")
    private Integer page;
}
