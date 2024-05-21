package com.zeabur.springboot.externalAPI.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class GameListResponseDto {
    List<GameListRowResponseDto> rows;
    String total;
    List<String> rule;
}

