package com.zeabur.springboot.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FunctionalException.class)
    public ResponseEntity<ErrorResponse> handleFunctionalException(FunctionalException ex, HttpServletRequest request) {
        System.out.println(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                ex.getErrorType().getHttpStatus().value(),
                ex.getErrorType().getHttpStatus().getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    record ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {}

}
