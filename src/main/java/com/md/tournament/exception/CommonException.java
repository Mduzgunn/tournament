package com.md.tournament.exception;


import org.springframework.http.HttpStatus;

public class CommonException extends IllegalArgumentException  {

    private final HttpStatus status;

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
