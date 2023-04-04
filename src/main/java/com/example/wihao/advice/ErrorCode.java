package com.example.wihao.advice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    BOOK_NOT_FOUND(-1000, "책을 찾을 수 없습니다.");

    private final int code;
    private final String message;
}
