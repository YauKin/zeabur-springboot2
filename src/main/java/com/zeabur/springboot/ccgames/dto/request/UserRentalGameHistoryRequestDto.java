package com.zeabur.springboot.ccgames.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zeabur.springboot.constant.GameListType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRentalGameHistoryRequestDto extends CommonUserRequestDto {
    @NotNull
    @JsonProperty("gameListType")
    private GameListType gameListType;
}
