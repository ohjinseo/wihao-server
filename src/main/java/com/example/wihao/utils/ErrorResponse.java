package com.example.wihao.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private int errorCode;
    private String errorMessage;
}
