package com.woori.backend.user.exception;

import com.woori.backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class EmailAlreadyExistsException extends RuntimeException {
    private final ErrorCode errorCode;

    public EmailAlreadyExistsException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
