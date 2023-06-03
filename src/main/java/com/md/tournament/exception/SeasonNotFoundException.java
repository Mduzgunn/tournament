package com.md.tournament.exception;

public class SeasonNotFoundException extends RuntimeException{
    public SeasonNotFoundException(String message) {
        super(message);
    }
}
