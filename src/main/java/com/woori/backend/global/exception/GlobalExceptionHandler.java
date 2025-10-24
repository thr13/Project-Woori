package com.woori.backend.global.exception;

import com.woori.backend.user.exception.EmailAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    protected ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
        log.error("이메일 중복 예외: {}", e.getErrorCode());
        ErrorResponse response = new ErrorResponse(e.getErrorCode());

        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
