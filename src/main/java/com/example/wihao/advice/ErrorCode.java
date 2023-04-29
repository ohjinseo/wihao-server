package com.example.wihao.advice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    BOOK_NOT_FOUND(-1000, "책을 찾을 수 없습니다."),
    POST_NOT_FOUND(-1001, "해당 게시글을 찾을 수 없습니다."),
    LOAN_NOT_FOUND(-1002, "해당 대여 정보를 찾을 수 없습니다."),

    LOAN_ALREADY_EXISTS(-1003, "이미 대여 정보가 존재합니다.");

    private final int code;
    private final String message;
}
