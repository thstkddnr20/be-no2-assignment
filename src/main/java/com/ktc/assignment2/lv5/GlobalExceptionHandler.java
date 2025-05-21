package com.ktc.assignment2.lv5;

import com.ktc.assignment2.lv5.exception.ErrorResponse;
import com.ktc.assignment2.lv5.exception.PasswordInvalidException;
import com.ktc.assignment2.lv5.exception.ScheduleNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PasswordInvalidException.class)
    public ResponseEntity<ErrorResponse> handlePasswordInvalidException(PasswordInvalidException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleScheduleNotFoundException(ScheduleNotFoundException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(BindException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            sb.append((fieldError.getDefaultMessage())).append(" ");
        }
        return ResponseEntity.badRequest().body(new ErrorResponse(sb.toString(), LocalDateTime.now()));
    }
}
