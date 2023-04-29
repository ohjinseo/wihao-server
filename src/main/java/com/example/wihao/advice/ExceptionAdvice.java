package com.example.wihao.advice;

import com.example.wihao.exception.BookNotFoundException;
import com.example.wihao.exception.LoanAlreadyExistsException;
import com.example.wihao.exception.LoanNotFoundException;
import com.example.wihao.exception.PostNotFoundException;
import com.example.wihao.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.wihao.advice.ErrorCode.*;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(BOOK_NOT_FOUND.getCode(), BOOK_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handlePostNotFoundException(PostNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(POST_NOT_FOUND.getCode(), POST_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleLoanNotFoundException(LoanNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(LOAN_NOT_FOUND.getCode(), LOAN_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(LoanAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorResponse> handleLoanAlreadyExistsException(LoanAlreadyExistsException e) {
        ErrorResponse errorResponse = new ErrorResponse(LOAN_ALREADY_EXISTS.getCode(), LOAN_ALREADY_EXISTS.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
