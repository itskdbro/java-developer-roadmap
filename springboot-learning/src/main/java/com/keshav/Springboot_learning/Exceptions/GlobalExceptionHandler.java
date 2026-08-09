package com.keshav.Springboot_learning.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Specific Exception for student not found - 404
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex) {
        LocalDateTime timestamp = LocalDateTime.now();
        ErrorResponse error = new ErrorResponse(404, ex.getMessage(), timestamp);
        return ResponseEntity.status(404).body(error);
    }

    // Genric Exceptions - 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenricException(Exception ex) {
        ErrorResponse error = new ErrorResponse(500, "Something went wrong", LocalDateTime.now());
        return ResponseEntity.status(500).body(error);
    }
}
