package com.sophia.movierentalapi.exceptions;

public class RentalNotFoundException extends RuntimeException{
    public RentalNotFoundException() {
        super("Rental Not Found");
    }
}
