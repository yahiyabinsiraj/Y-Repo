package com.example.microservice.collection.exception.controlleradvice;

import com.example.microservice.collection.exception.classes.ExceptionResponse;
import com.example.microservice.collection.exception.classes.FullDetailsRequired;
import com.example.microservice.collection.exception.classes.StudentAlreadyExists;
import com.example.microservice.collection.exception.classes.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
public class StudentControllerAdvice {

    private final ExceptionResponse exceptionResponse;

    public StudentControllerAdvice(ExceptionResponse exceptionResponse) {
        this.exceptionResponse = exceptionResponse;
    }

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ExceptionResponse> studentNotfound(StudentNotFound notFound) {
        exceptionResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setMessage(notFound.getMessage());
        exceptionResponse.setTraceId(UUID.randomUUID().toString().split("-")[4]);
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> studentAlreadyExists(StudentAlreadyExists alreadyExists) {
        exceptionResponse.setErrorCode(HttpStatus.CONFLICT.value());
        exceptionResponse.setMessage(alreadyExists.getMessage());
        exceptionResponse.setTraceId(UUID.randomUUID().toString().split("-")[4]);
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FullDetailsRequired.class)
    public ResponseEntity<ExceptionResponse> allDetailsRequired(FullDetailsRequired detailsRequired) {
        exceptionResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        exceptionResponse.setMessage(detailsRequired.getMessage());
        exceptionResponse.setTraceId(UUID.randomUUID().toString().split("-")[4]);
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
