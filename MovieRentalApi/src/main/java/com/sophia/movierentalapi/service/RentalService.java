package com.sophia.movierentalapi.service;

import com.sophia.movierentalapi.exceptions.InsufficientCopyException;
import com.sophia.movierentalapi.exceptions.RentalNotFoundException;
import com.sophia.movierentalapi.exceptions.UnauthorizedUserException;
import com.sophia.movierentalapi.model.Movie;
import com.sophia.movierentalapi.model.Rental;
import com.sophia.movierentalapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {
    private final UserService userService = new UserService();
    private final MovieService movieService = new MovieService();
    private List<Rental> rentals = new ArrayList<>();

    public RentalService() {
    }

    public Rental rentalMovie(int movieId, String username) {
        Movie movie = movieService.getMovie(movieId);
        User user = userService.getUser(username);
        if (movie.getCopies() == 0)
            throw new InsufficientCopyException();

        Rental rental = new Rental((rentals.size()+1), movie, user);
        movie.setCopies(movie.getCopies() - 1);
        rentals.add(rental);
        return rental;
    }

    public void returnMovie(int rentalId, String username) {
        Rental rental = getRental(rentalId);

        if (rental.getUser().getUsername().equals(username)) {
            rental.getMovie().setCopies(rental.getMovie().getCopies() + 1);
            rentals.remove(rental);
            return;

        }
        throw new UnauthorizedUserException();
    }


    public List<Rental> getAllRentals() { return rentals; }


    public Rental getRental(int rentalId) {
        for (Rental rental : rentals) {
            if (rental.getId() == rentalId)
                return rental;
        }
        throw new RentalNotFoundException();
    }
}
