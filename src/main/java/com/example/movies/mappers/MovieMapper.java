package com.example.movies.mappers;

import com.example.movies.dto.movie.MovieGetDTO;
import com.example.movies.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {


    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    MovieGetDTO toStudentDto(Movie student);
//    @Named("charactersToIds")
//    default Set<Integer> map(Set<Character> source) {
//        if(source == null)
//            return null;
//        return source.stream()
//                .map(s -> s.getId()).collect(Collectors.toSet());
//    }
    Movie toStudent(MovieGetDTO dto);
}
