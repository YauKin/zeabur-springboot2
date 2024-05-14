package com.zeabur.springboot.ccgames.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReserveGameRequestDto extends CommonUserRequestDto{
    @NotNull
    @JsonProperty("gameId")
    String gameId;
}
