package com.sophia.movierentalapi.exceptions;

public class UnauthorizedUserException extends RuntimeException {
    public UnauthorizedUserException() {
        super("User unauthorized");
    }

}
