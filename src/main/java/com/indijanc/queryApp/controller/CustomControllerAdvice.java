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
        GenericResponse genericResponse = GenericResponse.create()
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .withMessage("Data integrity violation")
                .withError("Unique index, primary key, or database constraint violation");

        return ResponseEntity.badRequest().body(genericResponse);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Object> handleFileUploadError(FileNotFoundException ex) {
        GenericResponse genericResponse = GenericResponse.create()
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .withMessage("Invalid file")
                .withError(ex.getMessage());

        return ResponseEntity.badRequest().body(genericResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex) {
        GenericResponse genericResponse = GenericResponse.create()
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withMessage("An error occurred")
                .withError(ex.getMessage());

        return ResponseEntity.internalServerError().body(genericResponse);
    }
}
