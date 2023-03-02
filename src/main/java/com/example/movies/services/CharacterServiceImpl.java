package com.example.movies.services;

import com.example.movies.model.Character;
import com.example.movies.model.Movie;
import com.example.movies.repositories.CharacterRepository;
import com.example.movies.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Collection;

public class CharacterServiceImpl implements CharacterService{
    private final CharacterRepository characterRepository;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        if(characterRepository.existsById(id)){
            return characterRepository.findById(id).get();
        }
        return null;

    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public Character update(Character entity) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        if(characterRepository.existsById(id)) {
            characterRepository.deleteById(id);
        }
        else
            logger.warn("No character exists with ID: " + id);
    }

    @Override
    @Transactional
    public void delete(Character entity) {
        if(characterRepository.equals(entity)){
            characterRepository.delete(entity);
        }
        else{
            logger.warn("Entity does not exist");
        }

    }

    @Override
    public Collection<Character> findAllByName(String name) {
        return characterRepository.findAllByName(name);
    }
}
