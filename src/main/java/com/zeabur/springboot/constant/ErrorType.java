package com.zeabur.springboot.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    GAME_LIST_NOT_FOUND("Game list not found", HttpStatus.BAD_REQUEST),
    INVALID_INPUT("Invalid input provided", HttpStatus.BAD_REQUEST),
    EXTERNAL_SERVICE_ERROR("External service error", HttpStatus.SERVICE_UNAVAILABLE);

    private final String logText;
    private final HttpStatus httpStatus;

    ErrorType(String logText, HttpStatus httpStatus) {
        this.logText = logText;
        this.httpStatus = httpStatus;
    }

}
