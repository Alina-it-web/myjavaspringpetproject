package com.simbirsoft.cmsproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReleaseNotFoundException extends RuntimeException {
    public ReleaseNotFoundException(String message) {
        super(message);
    }
}
