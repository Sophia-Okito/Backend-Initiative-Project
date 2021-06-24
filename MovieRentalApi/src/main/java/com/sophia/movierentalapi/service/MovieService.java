package com.sophia.movierentalapi.service;

import com.sophia.movierentalapi.exceptions.MovieNotFoundException;
import com.sophia.movierentalapi.exceptions.UnauthorizedUserException;
import com.sophia.movierentalapi.model.Movie;
import com.sophia.movierentalapi.model.User;
import com.sophia.movierentalapi.payload.MovieRequestMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final UserService userService = new UserService();
    private List<Movie> movies = new ArrayList<>();

    public MovieService() {
        movies.add(new Movie(1, "Fatherhood", 2));
        movies.add(new Movie(2, "Wedding Ringer", 4));
        movies.add(new Movie(3, "About Last Night", 1));
    }

    public Movie addMovie(MovieRequestMapper movie, String username) {
        User user = userService.getUser(username);
        if (!user.getRole().equals("admin"))
            throw new UnauthorizedUserException();
        Movie movie1 = new Movie();
        movie1.setId(movies.size() + 1);
        movie1.setTitle(movie.getTitle());
        movie1.setCopies(movie.getCopies());
        movies.add(movie1);
        return movie1;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovie(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id)
                return movie;
        }
        throw new MovieNotFoundException();
    }

    public Movie updateMovie(int id, MovieRequestMapper movie, String username) {
        User user = userService.getUser(username);
        if (!user.getRole().equals("admin"))
            throw new UnauthorizedUserException();

        for (Movie theMovie: movies) {
            if (theMovie.getId() == id){
                theMovie.setTitle(movie.getTitle());
                theMovie.setCopies(movie.getCopies());
                return theMovie;
            }
        }
        throw new MovieNotFoundException();
    }

    public void deleteMovie(int id, String username) {
        User user = userService.getUser(username);
        if (!user.getRole().equals("admin"))
            throw new UnauthorizedUserException();

        for (Movie theMovie : movies) {
            if (theMovie.getId() == id){
                movies.remove(theMovie);
                return;
            }
        }
        throw new MovieNotFoundException();
    }
}
