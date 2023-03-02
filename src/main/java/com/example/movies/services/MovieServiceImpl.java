package com.example.movies.services;

import com.example.movies.model.Franchise;
import com.example.movies.model.Movie;
import com.example.movies.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import org.slf4j.Logger;


@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie entity) {
        return null;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if(movieRepository.existsById(id)) {
            Movie movie = movieRepository.findById(id).get();
//            movie.getCharacters().forEach(s -> s.setCharacters(null));
//            movie.getMovies().forEach(s -> s.setFranchise(null));
            movieRepository.delete(movie);
        }
        else
            logger.warn("No movie exists with ID: " + id);
    }

    @Override
    @Transactional
    public void delete(Movie entity) {
        if(movieRepository.equals(entity)) {
            Movie movie = movieRepository.findById(entity.getId()).get();
//            movie.getCharacters().forEach(s -> s.setCharacters(null));
//            movie.getMovies().forEach(s -> s.setFranchise(null));
            movieRepository.delete(movie);
        }
        else
            logger.warn("No entity exists with entity title: " + entity.getTitle());
    }

    @Override
    @Transactional
    public void setFranchise(int movieId, int franchiseId) {
        if(movieRepository.existsById(movieId)) {
            movieRepository.updateMoviesFranchiseById(movieId, franchiseId);
        }
        else
            logger.warn("No movie exists with ID: " + movieId);

    }

    @Override
    public void setCharacter(int movieId, int characterId) {
        if(movieRepository.existsById(movieId)) {
            movieRepository.updateMoviesFranchiseById(movieId, characterId);
        }
        else
            logger.warn("No movie exists with ID: " + movieId);

    }

    @Override
    public Collection<Movie> findAllByName(String movieName) {
        return movieRepository.findAllByName(movieName);
    }


// omitted
}