package com.indijanc.queryApp.controller;

public class GenericResponse {
    private int status;
    private String error;
    private String message;

    private GenericResponse() {  }

    public static GenericResponse create() {
        return new GenericResponse();
    }

    public GenericResponse withStatus(int status) {
        this.status = status;
        return this;
    }

    public GenericResponse withError(String error) {
        this.error = error;
        return this;
    }

    public GenericResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
}
