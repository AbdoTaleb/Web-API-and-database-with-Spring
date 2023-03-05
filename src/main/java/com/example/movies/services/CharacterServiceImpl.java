package com.example.movies.services;

import com.example.movies.model.Character;
import com.example.movies.model.Movie;
import com.example.movies.repositories.CharacterRepository;
import com.example.movies.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService{
    private final CharacterRepository characterRepository;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
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
        return characterRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
            characterRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Character entity) {
        characterRepository.delete(entity);
    }


}
