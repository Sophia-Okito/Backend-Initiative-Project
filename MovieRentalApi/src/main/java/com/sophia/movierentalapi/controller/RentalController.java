package com.sophia.movierentalapi.controller;

import com.sophia.movierentalapi.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
public class RentalController {
    final
    RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<?> getRentals() {
        return new ResponseEntity<>(rentalService.getAllRentals(), HttpStatus.OK);
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<?> getUser(@PathVariable(value = "rentalId") int rentalId) {
        return new ResponseEntity<>(rentalService.getRental(rentalId), HttpStatus.OK);
    }


    @PostMapping("/{movieId}/{username}")
    public ResponseEntity<?> rentMovie(@PathVariable(value = "movieId") int movieId, @PathVariable(value = "username") String username) {
        return new ResponseEntity<>(rentalService.rentalMovie(movieId, username), HttpStatus.OK);
    }

    @DeleteMapping("/{rentalId}/{username}")
    public ResponseEntity<?> returnMovie(@PathVariable(value = "rentalId") int rentalId, @PathVariable(value = "username") String username) {
        rentalService.returnMovie(rentalId, username);
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }
}
