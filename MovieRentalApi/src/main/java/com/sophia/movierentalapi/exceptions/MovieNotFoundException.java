package com.sophia.movierentalapi.exceptions;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException() {
        super("Movie not found");
    }
}
