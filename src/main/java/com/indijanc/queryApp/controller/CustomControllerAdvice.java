package com.indijanc.queryApp.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        GenericResponse genericResponse = GenericResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Data integrity violation")
                .error("Unique index, primary key, or database constraint violation")
                .build();

        return ResponseEntity.badRequest().body(genericResponse);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleFileUploadError(NumberFormatException ex) {
        GenericResponse genericResponse = GenericResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Could not insert data")
                .error(ex.getMessage())
                .build();

        return ResponseEntity.badRequest().body(genericResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        GenericResponse genericResponse = GenericResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An error occurred")
                .error(ex.getMessage())
                .build();

        return ResponseEntity.internalServerError().body(genericResponse);
    }
}
