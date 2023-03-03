package com.example.movies.services;

import com.example.movies.model.Movie;

import java.util.Collection;
import java.util.Set;

public interface MovieService extends CrudService<Movie, Integer>{
    void setFranchise(int movieId, int franchiseId);
    void setCharacter(int movieId, int characterId);



}
