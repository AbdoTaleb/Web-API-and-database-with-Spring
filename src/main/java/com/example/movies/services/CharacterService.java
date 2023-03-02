package com.example.movies.services;

import com.example.movies.model.Character;
import com.example.movies.model.Franchise;
import com.example.movies.model.Movie;

import java.util.Collection;

public interface CharacterService extends CrudService<Character, Integer>{

    Collection<Character> findAllByName(String name);
}
