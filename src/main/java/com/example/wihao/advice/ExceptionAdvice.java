package com.example.wihao.advice;

import com.example.wihao.exception.BookNotFoundException;
import com.example.wihao.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.wihao.advice.ErrorCode.BOOK_NOT_FOUND;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(BOOK_NOT_FOUND.getCode(), BOOK_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
