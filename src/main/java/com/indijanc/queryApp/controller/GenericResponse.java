package com.indijanc.queryApp.controller;

import lombok.Builder;
import lombok.Getter;

/**
 * Generic response used for controller ok and error statuses
 */
@Getter
@Builder
public class GenericResponse {
    private int status;
    private String error;
    private String message;
}
