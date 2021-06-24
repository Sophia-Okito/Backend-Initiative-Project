package com.sophia.movierentalapi.exceptions;

public class InsufficientCopyException extends RuntimeException{
    public InsufficientCopyException() {
        super("Movie not available");
    }
}
