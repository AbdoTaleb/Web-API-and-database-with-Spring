package com.example.movies.services;

import com.example.movies.model.Character;


import java.util.Collection;

public interface CharacterService extends CrudService<Character, Integer>{

    Collection<Character> findAllByName(String name);
}
