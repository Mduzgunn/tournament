package com.md.tournament.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaximumPlayerLimitExceededException extends RuntimeException {
    public MaximumPlayerLimitExceededException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this; // Hata izleme bilgilerini atla
    }
}
