package com.example.movies.controllers;

import com.example.movies.dto.movie.MovieGetDTO;
import com.example.movies.mappers.MovieMapperImpl;
import com.example.movies.model.Movie;
import com.example.movies.repositories.MovieRepository;
import com.example.movies.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;


@RestController
@RequestMapping(path = "api/v1/movies") // Base URL
public class MoviesController {
    private final MovieService movieService;
    private final MovieMapperImpl movieMapper;
    private final MovieRepository movieRepository;

    public MoviesController(MovieService movieService, MovieMapperImpl movieMapper, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }
    @Operation(summary = "Get all movies")
    @GetMapping // GET: localhost:8080/api/v1/movies
    public ResponseEntity<Collection<Movie>> getAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @Operation(summary = "Get movie by specific ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieGetDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Movie does not exist with supplied ID",
                    content = @Content)

    })
    @GetMapping("{id}") // GET: localhost:8080/api/v1/movies/1
    public ResponseEntity<MovieGetDTO> getById(@PathVariable int id) {

        if(movieRepository.existsById(id)){
            MovieGetDTO movieGetDTO = movieMapper.toStudentDto(movieService.findById(id));
            return ResponseEntity.ok(movieGetDTO);
        }
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Add a new movie")
    @PostMapping // POST: localhost:8080/api/v1/movies
    public ResponseEntity add(@RequestBody Movie movieToAdd) {
        Movie movie = movieService.add(movieToAdd);
        URI location = URI.create("movies/" + movie.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update a movie")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Movie successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Movie not found with supplied ID",
                    content = @Content)
    })
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/movies/1
    public ResponseEntity update(@RequestBody Movie movie, @PathVariable int id) {
        // Validates if body is correct
        if(id != movie.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movie);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deleting a movie by its ID")
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/movies/1
    public ResponseEntity delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
