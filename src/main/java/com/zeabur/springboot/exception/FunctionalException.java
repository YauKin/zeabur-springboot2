package com.zeabur.springboot.exception;

import com.zeabur.springboot.constant.ErrorType;
public class FunctionalException extends RuntimeException {
    private final ErrorType errorType;
    private final String customMessage;

    public FunctionalException(ErrorType errorType) {
        super(errorType.getLogText());
        this.errorType = errorType;
        this.customMessage = null;
    }

    public FunctionalException(ErrorType errorType, String customMessage) {
        super(customMessage != null ? customMessage : errorType.getLogText());
        this.errorType = errorType;
        this.customMessage = customMessage;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
