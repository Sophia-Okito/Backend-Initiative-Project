package com.sophia.movierentalapi.controller;

import com.sophia.movierentalapi.payload.MovieRequestMapper;
import com.sophia.movierentalapi.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/movie")
public class MovieController {
    final
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/{username}")
    public ResponseEntity<?> registerMovie(@Valid @RequestBody MovieRequestMapper movie, @PathVariable(value = "username") String username) {
        return new ResponseEntity<>(movieService.addMovie(movie, username), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<?> getMovie(@PathVariable(value = "movieId") int movieId) {
        return new ResponseEntity<>(movieService.getMovie(movieId), HttpStatus.OK);
    }

    @PutMapping("/{movieId}/{username}")
    public ResponseEntity<?> updateMovie(@PathVariable(value = "movieId") int movieId, @PathVariable(value = "username") String username,  @Valid @RequestBody MovieRequestMapper movie) {
        return new ResponseEntity<>(movieService.updateMovie(movieId, movie, username), HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}/{username}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value = "movieId") int movieId, @PathVariable(value = "username") String username) {
        movieService.deleteMovie(movieId, username);
        return new ResponseEntity<>("Movie account deleted successfully", HttpStatus.OK);
    }


}

