package com.woori.backend.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    //User 오류 목록
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U001", "해당 유저를 찾을 수 없습니다."),
    EMAIL_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "U002", "이미 가입된 이메일 입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
