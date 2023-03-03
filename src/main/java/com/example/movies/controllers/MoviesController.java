package com.example.movies.controllers;

import com.example.movies.model.Movie;
import com.example.movies.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/movies") // Base URL
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping // GET: localhost:8080/api/v1/movies
    public ResponseEntity<Collection<Movie>> getAll() {
        return ResponseEntity.ok(movieService.findAll());
    }
}
