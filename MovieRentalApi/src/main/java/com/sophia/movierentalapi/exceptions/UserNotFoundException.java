package com.sophia.movierentalapi.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not Found");
    }
}
