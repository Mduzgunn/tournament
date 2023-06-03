package com.md.tournament.exception;

public class TeamAlreadyExistsException extends RuntimeException {
    public TeamAlreadyExistsException(String message) {
        super(message);
    }
}
