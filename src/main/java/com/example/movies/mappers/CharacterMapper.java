package com.example.movies.mappers;



import com.example.movies.model.Movie;
import com.example.movies.model.dto.character.CharacterDTO;

import com.example.movies.model.dto.movie.MovieDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {



    CharacterDTO characterToCharacterDto(Character character);

    Character characterDtoToCharacter(CharacterDTO dto);
}
