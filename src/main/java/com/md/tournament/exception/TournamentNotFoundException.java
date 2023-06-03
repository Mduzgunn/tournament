package com.md.tournament.exception;

public class TournamentNotFoundException extends RuntimeException {
    public TournamentNotFoundException(String message) {
        super(message);
    }
}
